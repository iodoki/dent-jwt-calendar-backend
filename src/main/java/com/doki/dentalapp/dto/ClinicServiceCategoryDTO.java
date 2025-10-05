package com.doki.dentalapp.dto;

import java.util.UUID;

public record ClinicServiceCategoryDTO(
        UUID id,
        String name,
        String description
) {}

