package com.doki.dentalapp.dto;

import java.util.UUID;

public record DoctorDTO (

    UUID id,
    UUID userId,
    UUID clinicId,
    String specialty,
    String firstName,
    String lastName,
    String fullName
){}

