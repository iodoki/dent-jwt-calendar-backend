package com.doki.dentalapp.service;


import com.doki.dentalapp.dto.ClinicUserDTO;
import com.doki.dentalapp.mapper.ClinicUserMapper;
import com.doki.dentalapp.model.*;
import com.doki.dentalapp.repository.ClinicRepository;
import com.doki.dentalapp.repository.ClinicUserRepository;
import com.doki.dentalapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClinicUserServiceImpl implements ClinicUserService {

    private final ClinicUserRepository repository;
    private final ClinicRepository clinicRepository;
    private final UserRepository userRepository;

    @Override
    public ClinicUserDTO create(ClinicUserDTO dto) {
        Clinic clinic = clinicRepository.findById(dto.clinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ClinicUser entity = ClinicUserMapper.toEntity(dto, clinic, user);
        return ClinicUserMapper.toDTO(repository.save(entity));
    }

    @Override
    public ClinicUserDTO get(UUID clinicId, UUID userId) {
        return repository.findById(new ClinicUserId(clinicId, userId))
                .map(ClinicUserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<ClinicUserDTO> getAll() {
        return repository.findAll().stream()
                .map(ClinicUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID clinicId, UUID userId) {
        repository.deleteById(new ClinicUserId(clinicId, userId));
    }

}
