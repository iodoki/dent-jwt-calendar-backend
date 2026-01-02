package com.doki.dentalapp.service;


import com.doki.dentalapp.dto.*;
import com.doki.dentalapp.mapper.*;
import com.doki.dentalapp.model.*;
import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final HelperService helperService;
    private final PatientServiceRecordRepository patientServiceRecordRepository;
    private final PatientAllergyRecordRepository patientAllergyRecordRepository;

    public List<PatientDTO> getAll() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientDTO getById(UUID id) {
        return PatientMapper.toDTO(helperService.findPatient(id));
    }

    public PatientDTO create(PatientDTO dto) {
        Clinic clinic = helperService.resolveClinicFromSecurity();

        Patient patient = PatientMapper.toEntity(dto, clinic);
        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    public PatientDTO update(UUID id, PatientDTO dto) {
        Clinic clinic = helperService.resolveClinicFromSecurity();

        Patient existing = helperService.findPatient(id);

        existing.setFirstName(dto.firstName());
        existing.setLastName(dto.lastName());
        existing.setFatherName(dto.fatherName());
        existing.setEmail(dto.email());
        existing.setPhone(dto.phone());
        existing.setDateOfBirth(dto.dateOfBirth());
        existing.setClinic(clinic);

        return PatientMapper.toDTO(patientRepository.save(existing));
    }

    public void delete(UUID id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> search(String term, Pageable pageable) {
        Clinic clinic = helperService.resolveClinicFromSecurity();

        return patientRepository.search(clinic.getId(), term, pageable).stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentNServicesDTO> getPatientAppointmentHistory(UUID id) {
        Patient patient = helperService.findPatient(id);

        List<PatientServiceRecord> records = patientServiceRecordRepository.findAllByPatient_Id(patient.getId());
        List<AppointmentNServicesDTO> appointments = new ArrayList<>();
        records.forEach(patientServiceRecord -> {
            Appointment appointment = patientServiceRecord.getAppointment();
            if (appointment != null) {
                List<ClinicService> services = patientServiceRecordRepository.findServicesByAppointmentId(appointment.getId());
                List<ServiceNCategoryDTO> servicesNCategories = services.stream()
                        .map(clinicService -> {
                            return ServiceNCategoryMapper.toSlimDTO(clinicService, patientServiceRecord.getDescription());

                        }).collect(Collectors.toList());

                if (!appointments.contains(AppointmentNServicesMapper.toDTO(appointment, servicesNCategories))) {
                    appointments.add(AppointmentNServicesMapper.toDTO(appointment, servicesNCategories));

                }
            }
        });
        return appointments;
    }

    @Override
    public void updatePatientAllergyHistory(UUID id, List<PatientAllergyRecordDTO> allergies) {
        Patient patient = helperService.findPatient(id);

        if (patient != null) {
            allergies
                    .forEach(newPatientAllergyRecord ->
                    {
                        Optional<PatientAllergyRecord> existentPatientAllergyRecord = patientAllergyRecordRepository.findById(newPatientAllergyRecord.id());
                        if (existentPatientAllergyRecord.isPresent()) {
                            existentPatientAllergyRecord.get().setHasPastRecord(newPatientAllergyRecord.answer());
                            existentPatientAllergyRecord.get().setNote(newPatientAllergyRecord.note());
                            patientAllergyRecordRepository.save(existentPatientAllergyRecord.get());
                        }

                    });
        }

    }

    @Override
    public List<PatientAllergyRecordDTO> getPatientAllergyHistory(UUID id) {
        Patient patient = helperService.findPatient(id);
        List<PatientAllergyRecord> allergyRecords = patientAllergyRecordRepository.findAllByPatient_Id(patient.getId());

        return allergyRecords.stream()
                .map(PatientAllergyRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

}
