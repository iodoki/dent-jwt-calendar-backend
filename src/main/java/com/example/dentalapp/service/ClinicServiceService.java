package com.example.dentalapp.service;

import com.example.dentalapp.dto.ClinicServiceDTO;

import java.util.List;
import java.util.UUID;

public interface ClinicServiceService {
    List<ClinicServiceDTO> getAll();

    ClinicServiceDTO getById(UUID id);

    ClinicServiceDTO create(ClinicServiceDTO dto);

    ClinicServiceDTO update(UUID id, ClinicServiceDTO dto);

    void delete(UUID id);
}
