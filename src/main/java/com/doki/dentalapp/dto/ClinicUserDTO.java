package com.doki.dentalapp.dto;

import java.util.UUID;

public record ClinicUserDTO(
        UUID clinicId,
        UUID userId
) {}
