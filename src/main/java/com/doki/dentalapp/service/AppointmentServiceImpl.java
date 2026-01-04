package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentNServicesDTO;
import com.doki.dentalapp.dto.PatientDTO;
import com.doki.dentalapp.dto.ServiceNCategoryDTO;
import com.doki.dentalapp.exeption.ClinicServiceNotFoundException;
import com.doki.dentalapp.mapper.*;
import com.doki.dentalapp.model.*;
import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.repository.*;
import com.doki.dentalapp.util.AppointmentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ClinicServiceRepository serviceRepository;
    private final PatientService patientService;
    private final PatientServiceRecordRepository patientServiceRecordRepository;
    private final AllergyQuestionRepository allergyQuestionRepository;
    private final HelperService helperService;
    private final PatientAllergyRecordRepository patientAllergyRecordRepository;

    @Override
    @Transactional
    public AppointmentNServicesDTO createAppointment(AppointmentNServicesDTO dto) {

        Clinic clinic = helperService.resolveClinicFromSecurity();
        Doctor doctor = helperService.findDoctor(dto.doctor().id());
        Patient patient = createOrUpdatePatientEntity(dto.patient(), clinic);

        Appointment appointment =
                createAndSaveAppointment(dto, clinic, doctor, patient);

        List<ServiceNCategoryDTO> services =
                handleAppointmentServices(
                        dto.services(),
                        appointment,
                        patient,
                        "OnCreate"
                );

        return AppointmentNServicesMapper.toDTO(appointment, services);
    }

    @Override
    public AppointmentNServicesDTO getAppointment(UUID id) {
        Appointment appointment = helperService.findAppointment(id);
        List<ServiceNCategoryDTO> services = helperService.processServiceNCategoriesFromPatientServiceRecord(id);
        return AppointmentNServicesMapper.toDTO(appointment, services);
    }


    @Override
    public AppointmentNServicesDTO updateAppointment(UUID id, AppointmentNServicesDTO dto) {
        Clinic clinic = helperService.resolveClinicFromSecurity();
        Doctor doctor = helperService.findDoctor(dto.doctor().id());

        Patient patient = createOrUpdatePatientEntity(dto.patient(), clinic);

        Appointment appointment = helperService.findAppointment(id);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStartTime(dto.startTime());
        appointment.setEndTime(dto.endTime());
        appointment.setStatus(dto.status());
        appointment.setNotes(dto.notes());
        appointment.setActive(Boolean.TRUE);
        appointment.setUpdatedAt(LocalDateTime.now());

        List<ServiceNCategoryDTO> services =
                handleAppointmentServices(
                        dto.services(),
                        appointment,
                        patient,
                        "NaN"
                );

        return AppointmentNServicesMapper.toDTO(appointment, services);
    }

    @Override
    public void deleteAppointment(UUID id) {
        //TODO: soft delete  on appointments - set active to false
        Appointment appointment = helperService.findAppointment(id);
        appointment.setActive(Boolean.FALSE);
        appointment.setStatus(AppointmentStatus.CANCELLED.name());
        appointmentRepository.save(appointment);
        //TODO: soft or hard delete for services related to appointment

        List<PatientServiceRecord> patientRecords = patientServiceRecordRepository.findAllByAppointment_Id(id);
        patientRecords.forEach(patientServiceRecordRepository::delete);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentNServicesDTO> findAppointmentsByClinicAndStartEndDateBetween(LocalDate startDate, LocalDate endDate, String view) {
        if (startDate == null) startDate = LocalDate.now();
        if (endDate == null) endDate = startDate.plusMonths(1);

        OffsetDateTime startDateTime = startDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        OffsetDateTime endDateTime = endDate.plusDays(1).atStartOfDay().minusSeconds(1).atOffset(ZoneOffset.UTC);
        Clinic clinic = helperService.resolveClinicFromSecurity();

        return appointmentRepository.findByClinicIdAndStartEndTimeBetween(clinic.getId(), startDateTime, endDateTime).stream()
                .map(appointment -> {
                    List<ServiceNCategoryDTO> servicesNCategories = helperService.processServiceNCategoriesFromPatientServiceRecord(appointment.getId());
                    return AppointmentNServicesMapper.toDTO(appointment, servicesNCategories);
                })
                .collect(Collectors.toList());


    }

    @Override
    public List<AppointmentNServicesDTO> findAppointmentsByClinicAndGivenDate(LocalDate date) {
        Clinic clinic = helperService.resolveClinicFromSecurity();
        OffsetDateTime startOfDay = date.atStartOfDay().atOffset(ZoneOffset.UTC);
        OffsetDateTime endOfDay = date.plusDays(1).atStartOfDay().minusNanos(1).atOffset(ZoneOffset.UTC);

        return appointmentRepository.findByClinicIdAndStartEndTimeBetween(clinic.getId(), startOfDay, endOfDay).stream()
                .map(appointment -> {
                    List<ServiceNCategoryDTO> servicesNCategories = helperService.processServiceNCategoriesFromPatientServiceRecord(appointment.getId());
                    return AppointmentNServicesMapper.toDTO(appointment, servicesNCategories);
                }).collect(Collectors.toList());
    }

    public List<ServiceNCategoryDTO> handleAppointmentServices(
            List<ServiceNCategoryDTO> serviceDTOs,
            Appointment appointment,
            Patient patient,
            String description
    ) {

        if (serviceDTOs.isEmpty() || appointment.getId() == null) {
            return List.of();
        }

        List<PatientServiceRecord> patientRecords = patientServiceRecordRepository.
                findAllByAppointment_IdAndPatient_Id(
                        appointment.getId(),
                        patient.getId()
                );

        patientRecords.forEach(patientServiceRecordRepository::delete);

        return serviceDTOs.stream()
                .map(dto ->
                        processService(dto, appointment, patient, description)
                )
                .collect(Collectors.toList());
    }

    private ServiceNCategoryDTO processService(
            ServiceNCategoryDTO serviceDto,
            Appointment appointment,
            Patient patient,
            String description
    ) {


        ClinicService clinicService =
                serviceRepository.findById(serviceDto.service().id())
                        .orElseThrow(() ->
                                new ClinicServiceNotFoundException(
                                        serviceDto.service().id()
                                )
                        );

        PatientServiceRecord newRecord = createAndSavePatientServiceRecord(
                clinicService,
                patient,
                appointment,
                description
        );


        return ServiceNCategoryMapper.toSlimDTO(clinicService, newRecord.getDescription());
    }

    private Patient createOrUpdatePatientEntity(
            PatientDTO patientDTO,
            Clinic clinic
    ) {

        if (patientDTO.id() != null) {
            PatientDTO updated =
                    patientService.update(patientDTO.id(), patientDTO);
            return PatientMapper.toEntity(updated, clinic);
        }

        Patient newPatient = Patient.builder()
                .firstName(patientDTO.firstName())
                .lastName(patientDTO.lastName())
                .email(patientDTO.email())
                .phone(patientDTO.phone())
                .dateOfBirth(patientDTO.dateOfBirth())
                .fatherName(patientDTO.fatherName())
                .clinic(clinic)
                .build();

        PatientDTO created =
                patientService.create(PatientMapper.toDTO(newPatient));

        List<AllergyQuestion> clinicQuestions = allergyQuestionRepository.findAllByClinic_Id(clinic.getId());
        newPatientAllergyRecords(PatientMapper.toEntity(created, clinic), clinicQuestions);

        return PatientMapper.toEntity(created, clinic);
    }

    private void newPatientAllergyRecords(Patient patient, List<AllergyQuestion> questions) {
        List<PatientAllergyRecord> existingPatientAllergies = patientAllergyRecordRepository.findAllByPatient_Id(patient.getId());
        if (existingPatientAllergies.isEmpty()) {
            questions
                    .forEach(question -> {
                        PatientAllergyRecord patientAllergyRecord = PatientAllergyRecord.builder()
                                .patient(patient)
                                .allergyQuestion(question)
                                .hasPastRecord(false)
                                .note("")
                                .build();
                        patientAllergyRecordRepository.save(patientAllergyRecord);

                    });

        }
    }



    private Appointment createAndSaveAppointment(
            AppointmentNServicesDTO dto,
            Clinic clinic,
            Doctor doctor,
            Patient patient
    ) {

        Appointment appointment = Appointment.builder()
                .startTime(dto.startTime())
                .endTime(dto.endTime())
                .status(dto.status())
                .patient(patient)
                .doctor(doctor)
                .clinic(clinic)
                .notes(dto.notes())
                .status(AppointmentStatus.SCHEDULED.name())
                .createdAt(LocalDateTime.now())
                .active(Boolean.TRUE)
                .build();

        return appointmentRepository.save(appointment);
    }

    private PatientServiceRecord createAndSavePatientServiceRecord(
            ClinicService clinicService,
            Patient patient,
            Appointment appointment,
            String description
    ) {

        PatientServiceRecord record =
                PatientServiceRecord.builder()
                        .patient(patient)
                        .service(clinicService)
                        .date(LocalDateTime.now())
                        .appointment(appointment)
                        .description(description)
                        .createdAt(LocalDateTime.now())
                        .active(Boolean.TRUE)
                        .build();

        return patientServiceRecordRepository.save(record);
    }
}
