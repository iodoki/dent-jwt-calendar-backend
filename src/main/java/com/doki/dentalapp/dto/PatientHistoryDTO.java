package com.doki.dentalapp.dto;

import java.util.List;

public record PatientHistoryDTO(
        PatientDTO patient,
        List<AppointmentNServicesDTO> appointments,
        List<PatientAllergyRecordDTO> allergies
        ) {}
