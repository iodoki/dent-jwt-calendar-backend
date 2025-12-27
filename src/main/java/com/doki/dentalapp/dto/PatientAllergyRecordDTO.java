package com.doki.dentalapp.dto;

import java.util.UUID;

public record PatientAllergyRecordDTO(
        UUID id,
        UUID questionId,
        String question,
        Boolean answer,
        String note) {


}
