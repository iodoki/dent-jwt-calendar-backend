package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.PatientAllergyRecordDTO;
import com.doki.dentalapp.model.AllergyQuestion;
import com.doki.dentalapp.model.Patient;
import com.doki.dentalapp.model.PatientAllergyRecord;

public class PatientAllergyRecordMapper {
    public static PatientAllergyRecordDTO toDTO(PatientAllergyRecord patientAllergyRecord) {
        if (patientAllergyRecord == null) return null;
        return new PatientAllergyRecordDTO(
                patientAllergyRecord.getId(),
                patientAllergyRecord.getAllergyQuestion().getId(),
                patientAllergyRecord.getAllergyQuestion().getDescription(),
                patientAllergyRecord.getHasPastRecord(),
                patientAllergyRecord.getNote()
        );
    }

    public static PatientAllergyRecord toEntity(
            PatientAllergyRecordDTO dto,
            Patient patient,
            AllergyQuestion question) {
        if (dto == null) return null;
        return new PatientAllergyRecord(
                dto.id(),
                patient,
                question,
                dto.answer(),
                dto.note()
        );
    }

}
