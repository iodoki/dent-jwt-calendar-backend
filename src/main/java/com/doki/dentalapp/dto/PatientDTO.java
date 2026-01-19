package com.doki.dentalapp.dto;

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
        Boolean active,
        String gender,
        String profession,
        String address,
        String identityNumber,
        String healthCareNumber,
        UUID clinicId
) {}