package com.doki.dentalapp.dto;

import java.util.UUID;

public record ServiceSlimDTO(
        UUID id,
        String name,
        String currency,
        Double price
) {}
