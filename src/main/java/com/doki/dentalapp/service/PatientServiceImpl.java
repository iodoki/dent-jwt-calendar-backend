package com.doki.dentalapp.service;


import com.doki.dentalapp.dto.*;
import com.doki.dentalapp.mapper.*;
import com.doki.dentalapp.model.*;
import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.repository.*;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    private final AllergyQuestionRepository allergyQuestionRepository;

    public List<PatientDTO> getAll() {
        Clinic clinic = helperService.resolveClinicFromSecurity();

        return patientRepository.findAllActiveByClinic_Id(clinic.getId()).stream()
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
        existing.setGender(dto.gender());
        existing.setProfession(dto.profession());
        existing.setAddress(dto.address());
        existing.setClinic(clinic);

        return PatientMapper.toDTO(patientRepository.save(existing));
    }

    public void delete(UUID id) {
        Patient patient = helperService.findPatient(id);
        patient.setActive(false);
        patient.setUpdatedAt(LocalDateTime.now());
        patientRepository.save(patient);
       // patientRepository.delete(patient);
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

                if (!appointments.contains(AppointmentNServicesMapper.toDTO(
                        appointment,
                        servicesNCategories,
                        new PaymentDTO(0.0,0.0, 0.0,false)))) {
                    appointments.add(AppointmentNServicesMapper.toDTO(
                            appointment,
                            servicesNCategories,
                    new PaymentDTO(0.0,0.0, 0.0,false)));

                }
            }
        });
        return appointments;
    }

    @Override
    public void updatePatientAllergyHistory(UUID id, List<PatientAllergyRecordDTO> allergies) {
        System.out.println("updatePatientAllergyHistory... : " + id + " " + allergies.size());

        allergies.forEach(patientAllergyRecord -> {
            System.out.println(patientAllergyRecord.id());
            System.out.println(patientAllergyRecord.questionId());
            System.out.println(patientAllergyRecord.question());

            System.out.println(patientAllergyRecord.answer());
            System.out.println(patientAllergyRecord.note());



            if (id != null && patientAllergyRecord.questionId() != null) {
                System.out.println("updatePatientAllergyHistory : " + id + " " + patientAllergyRecord.questionId());

                Patient patient = helperService.findPatient(id);
                AllergyQuestion question = helperService.findQuestion(patientAllergyRecord.questionId());
                upsert(
                        patient,
                        question,
                        patientAllergyRecord.answer(),
                        patientAllergyRecord.note());
            }
        });

    }

    @Override
    public List<PatientAllergyRecordDTO> getPatientAllergyHistory(UUID id) {
        Patient patient = helperService.findPatient(id);
        List<PatientAllergyRecord> allergyRecords = patientAllergyRecordRepository.findAllByPatient_Id(patient.getId());

        return allergyRecords.stream()
                .map(PatientAllergyRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeDuplicateAllergies(UUID patientId) {
        List<PatientAllergyRecord> allergies = patientAllergyRecordRepository.findAllByPatient_Id(patientId);

        Map<String, PatientAllergyRecord> unique = new HashMap<>();
        List<PatientAllergyRecord> duplicates = new ArrayList<>();

        for (PatientAllergyRecord allergy : allergies) {
            String key = allergy.getAllergyQuestion().getId().toString();

            if (!unique.containsKey(key)) {
                unique.put(key, allergy);
            } else {
                duplicates.add(allergy);
            }
        }

        patientAllergyRecordRepository.deleteAll(duplicates);
    }

    public void upsert(Patient patient, AllergyQuestion question, Boolean hasPast, String note) {

        PatientAllergyRecord record = patientAllergyRecordRepository
                .findByPatient_IdAndAllergyQuestion_Id(patient.getId(), question.getId())
                .orElseGet(() -> {
                    PatientAllergyRecord newRecord = new PatientAllergyRecord();
                    newRecord.setPatient(patient);
                    newRecord.setAllergyQuestion(question);
                    System.out.println("upsert new record: " + newRecord.getId() + newRecord.getAllergyQuestion().getId() + newRecord.getNote());
                    return newRecord;
                });

        // ✅ ONLY update the fields you want
        System.out.println("upsert record: " + record.getId() + record.getAllergyQuestion().getId() + record.getNote());
        record.setHasPastRecord(hasPast);
        record.setNote(note);
        patientAllergyRecordRepository.save(record);
    }

}
