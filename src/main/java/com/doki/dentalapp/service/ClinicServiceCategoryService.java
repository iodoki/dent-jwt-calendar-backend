package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.ClinicServiceCategoryDTO;

import java.util.List;
import java.util.UUID;

public interface ClinicServiceCategoryService {

    List<ClinicServiceCategoryDTO> getAll();

    ClinicServiceCategoryDTO getById(UUID id);

    ClinicServiceCategoryDTO create(ClinicServiceCategoryDTO dto);

    ClinicServiceCategoryDTO update(UUID id, ClinicServiceCategoryDTO dto);

    void delete(UUID id);
}
