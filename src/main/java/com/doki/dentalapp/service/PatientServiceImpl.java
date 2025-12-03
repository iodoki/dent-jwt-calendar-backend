package com.doki.dentalapp.service;


import com.doki.dentalapp.dto.PatientDTO;
import com.doki.dentalapp.mapper.PatientMapper;
import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.model.Patient;
import com.doki.dentalapp.repository.ClinicRepository;
import com.doki.dentalapp.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ClinicRepository clinicRepository;

    public List<PatientDTO> getAll() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientDTO getById(UUID id) {
        return patientRepository.findById(id)
                .map(PatientMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public PatientDTO create(PatientDTO dto) {
        Clinic clinic = clinicRepository.findById(dto.clinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        Patient patient = PatientMapper.toEntity(dto, clinic);
        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    public PatientDTO update(UUID id, PatientDTO dto) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        existing.setFirstName(dto.firstName());
        existing.setLastName(dto.lastName());
        existing.setFatherName(dto.fatherName());
        existing.setEmail(dto.email());
        existing.setPhone(dto.phone());
        existing.setDateOfBirth(dto.dateOfBirth());

        if (dto.clinicId() != null) {
            Clinic clinic = clinicRepository.findById(dto.clinicId())
                    .orElseThrow(() -> new RuntimeException("Clinic not found"));
            existing.setClinic(clinic);
        }

        return PatientMapper.toDTO(patientRepository.save(existing));
    }

    public void delete(UUID id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> search(String term, Pageable pageable) {
        return patientRepository.search(term, pageable).stream()
                .map(PatientMapper::toDTO)
                .toList();
    }
}
