package com.example.dentalapp.service;

import com.example.dentalapp.dto.ClinicDTO;
import com.example.dentalapp.mapper.ClinicMapper;
import com.example.dentalapp.model.Clinic;
import com.example.dentalapp.repository.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;

    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<ClinicDTO> getAll() {
        return clinicRepository.findAll().stream()
                .map(ClinicMapper::toDTO)
                .toList();
    }

    @Override
    public ClinicDTO getById(UUID id) {
        return clinicRepository.findById(id)
                .map(ClinicMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
    }

    @Override
    public ClinicDTO create(ClinicDTO dto) {
        Clinic clinic = ClinicMapper.toEntity(dto);
        return ClinicMapper.toDTO(clinicRepository.save(clinic));
    }

    @Override
    public ClinicDTO update(UUID id, ClinicDTO dto) {
        Clinic existing = clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        existing.setName(dto.name());
        existing.setAddress(dto.address());
        existing.setPhone(dto.phone());
        existing.setEmail(dto.email());
        existing.setNipt(dto.nipt());

        return ClinicMapper.toDTO(clinicRepository.save(existing));
    }

    @Override
    public void delete(UUID id) {
        clinicRepository.deleteById(id);
    }
}
