package com.doki.dentalapp.dto;

import java.util.UUID;

public record ClinicDTO(
        UUID id,
        String name,
        String address,
        String phone,
        String email,
        String nipt
) {}
