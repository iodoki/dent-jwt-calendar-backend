package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentDTO;
import com.doki.dentalapp.dto.PatientDTO;
import com.doki.dentalapp.mapper.PatientMapper;
import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.model.Doctor;
import com.doki.dentalapp.model.Patient;
import com.doki.dentalapp.mapper.AppointmentMapper;
import com.doki.dentalapp.repository.AppointmentRepository;
import com.doki.dentalapp.repository.ClinicRepository;
import com.doki.dentalapp.repository.ClinicServiceRepository;
import com.doki.dentalapp.repository.DoctorRepository;
import com.doki.dentalapp.repository.PatientRepository;
import com.doki.dentalapp.security.MyJwtAuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ClinicServiceRepository serviceRepository;
    private final ClinicRepository clinicRepository;
    private final PatientService patientService;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO dto) {
        Doctor doctor = doctorRepository.findById(dto.doctor().id())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        MyJwtAuthenticationToken auth = (MyJwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        Clinic clinic = clinicRepository.findById(UUID.fromString(auth.getClinicId()))
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        Patient newPatient = Patient.
                builder()
                .firstName(dto.patient().firstName())
                .lastName(dto.patient().lastName())
                .email(dto.patient().email())
                .phone(dto.patient().phone())
                .dateOfBirth(dto.patient().dateOfBirth())
                .fatherName(dto.patient().fatherName())
                .clinic(clinic)
                .build();

        PatientDTO patientDTO = dto.patient().id() != null
                ? patientService.update(dto.patient().id(), dto.patient())
                : patientService.create(PatientMapper.toDTO(newPatient));

        Appointment newAppointment = Appointment.
                builder()
                .startTime(dto.startTime())
                .endTime(dto.endTime())
                .notes(dto.description())
                .status(dto.status())
                .patient(PatientMapper.toEntity(patientDTO, clinic))
                .doctor(doctor)
                .clinic(clinic)
                .build();

        return AppointmentMapper.toDTO(appointmentRepository.save(newAppointment));

    }

    @Override
    public AppointmentDTO getAppointment(UUID id) {
        return appointmentRepository.findById(id)
                .map(AppointmentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }


    @Override
    public AppointmentDTO updateAppointment(UUID id, AppointmentDTO dto) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Doctor doctor = doctorRepository.findById(dto.doctor().id())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
 //       Patient patient = patientRepository.findById(dto.patient().id())
 //               .orElseThrow(() -> new RuntimeException("Patient not found"));
//        Clinic clinic = clinicRepository.findById(dto.clinicId())
//                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        appointment.setDoctor(doctor);
       // appointment.setPatient(patient);
      //  appointment.setClinic(clinic);
        appointment.setStartTime(dto.startTime());
        appointment.setEndTime(dto.endTime());
        appointment.setStatus(dto.status());
        appointment.setNotes(dto.description());

        return AppointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    @Override
    public void deleteAppointment(UUID id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByClinicAndStartEndDateBetween(LocalDate startDate, LocalDate endDate, String view) {
        if (startDate == null) startDate = LocalDate.now();
        if (endDate == null) endDate = startDate.plusMonths(1);

        OffsetDateTime startDateTime = startDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        OffsetDateTime endDateTime = endDate.plusDays(1).atStartOfDay().minusSeconds(1).atOffset(ZoneOffset.UTC);
        MyJwtAuthenticationToken auth = (MyJwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        return appointmentRepository.findByClinicIdAndStartEndTimeBetween(UUID.fromString(auth.getClinicId()), startDateTime, endDateTime).stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByClinicAndGivenDate(LocalDate date) {
        OffsetDateTime startOfDay = date.atStartOfDay().atOffset(ZoneOffset.UTC);
        OffsetDateTime endOfDay = date.plusDays(1).atStartOfDay().minusNanos(1).atOffset(ZoneOffset.UTC);
        MyJwtAuthenticationToken auth = (MyJwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        return appointmentRepository.findByClinic_IdAndStartTimeBetween(UUID.fromString(auth.getClinicId()), startOfDay, endOfDay).stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByPatient(UUID patientId) {
        MyJwtAuthenticationToken auth = (MyJwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

//        Patient patient = patientRepository.findById(patientId)
//                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return appointmentRepository.findAppointmentsByPatient(UUID.fromString(auth.getClinicId()), patientId).stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
