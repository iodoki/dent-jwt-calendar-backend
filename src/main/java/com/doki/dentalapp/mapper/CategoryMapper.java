package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.CategorySlimDTO;
import com.doki.dentalapp.model.ClinicServiceCategory;

public class CategoryMapper {

    public static CategorySlimDTO toSlimDTO(ClinicServiceCategory category) {
        return new CategorySlimDTO(
                category.getId(),
                category.getName()
        );
    }
}
