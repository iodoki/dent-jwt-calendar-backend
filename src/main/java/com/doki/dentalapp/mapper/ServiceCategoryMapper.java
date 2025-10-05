package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.ClinicServiceCategoryDTO;
import com.doki.dentalapp.model.ClinicServiceCategory;

public class ServiceCategoryMapper {

    public static ClinicServiceCategoryDTO toDTO(ClinicServiceCategory category) {
        return new ClinicServiceCategoryDTO(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

    public static ClinicServiceCategory toEntity(ClinicServiceCategoryDTO dto) {
        ClinicServiceCategory category = new ClinicServiceCategory();
        category.setId(dto.id());
        category.setName(dto.name());
        category.setDescription(dto.description());
        return category;
    }
}
