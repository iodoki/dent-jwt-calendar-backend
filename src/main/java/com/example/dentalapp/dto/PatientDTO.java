package com.example.dentalapp.dto;

import java.time.LocalDate;
import java.util.UUID;

public record PatientDTO(
        UUID id,
        String firstName,
        String lastName,
        String fatherName,
        String email,
        String phone,
        LocalDate dateOfBirth,
        UUID clinicId,
        UUID userId
) {}