package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.ClinicDTO;

import java.util.List;
import java.util.UUID;

public interface ClinicService {

    List<ClinicDTO> getAll();

    ClinicDTO getById(UUID id);

    ClinicDTO create(ClinicDTO dto);

    ClinicDTO update(UUID id, ClinicDTO dto);

    void delete(UUID id);
}
