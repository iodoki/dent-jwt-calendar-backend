package com.doki.dentalapp.dto;

import java.util.UUID;

public record ClinicServiceDTO(
        UUID id,
        String name,
        double price,
        String currency,
        UUID clinicId,
        UUID categoryId,
        String categoryName
) {}
