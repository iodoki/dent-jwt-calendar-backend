package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.ClinicUserDTO;

import java.util.List;
import java.util.UUID;

public interface ClinicUserService {
    ClinicUserDTO create(ClinicUserDTO dto);
    ClinicUserDTO get(UUID clinicId, UUID userId);
    List<ClinicUserDTO> getAll();
    void delete(UUID clinicId, UUID userId);
}
