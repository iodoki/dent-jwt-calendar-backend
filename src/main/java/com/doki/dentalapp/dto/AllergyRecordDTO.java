package com.doki.dentalapp.dto;

import com.doki.dentalapp.model.AllergyQuestion;

public record AllergyRecordDTO(
        AllergyQuestion allergyQuestion,
        Boolean hasPastRecord,
        String note) {


}
