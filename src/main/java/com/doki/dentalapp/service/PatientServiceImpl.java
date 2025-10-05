package com.doki.dentalapp.service;


import com.doki.dentalapp.dto.PatientDTO;
import com.doki.dentalapp.mapper.PatientMapper;
import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.model.Patient;
import com.doki.dentalapp.model.User;
import com.doki.dentalapp.repository.ClinicRepository;
import com.doki.dentalapp.repository.PatientRepository;
import com.doki.dentalapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ClinicRepository clinicRepository;
    private final UserRepository userRepository;

    public PatientServiceImpl(PatientRepository patientRepository, ClinicRepository clinicRepository, UserRepository userRepository) {
        this.patientRepository = patientRepository;
        this.clinicRepository = clinicRepository;
        this.userRepository = userRepository;
    }

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

        User user = dto.userId() != null
                ? userRepository.findById(dto.userId()).orElse(null)
                : null;

        Patient patient = PatientMapper.toEntity(dto, clinic, user);
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

        if (dto.userId() != null) {
            User user = userRepository.findById(dto.userId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existing.setUser(user);
        }

        return PatientMapper.toDTO(patientRepository.save(existing));
    }

    public void delete(UUID id) {
        patientRepository.deleteById(id);
    }
}
