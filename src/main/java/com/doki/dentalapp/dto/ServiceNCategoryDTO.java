package com.doki.dentalapp.dto;

public record ServiceNCategoryDTO(
        CategorySlimDTO category,
        ServiceSlimDTO service,
        String description
) {}
