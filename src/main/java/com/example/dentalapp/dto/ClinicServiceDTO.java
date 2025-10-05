package com.example.dentalapp.dto;

import java.util.UUID;

public record ClinicServiceDTO(
        UUID id,
        String name,
        double price,
        UUID clinicId,
        UUID categoryId
) {}
