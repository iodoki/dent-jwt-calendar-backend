package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.*;
import com.doki.dentalapp.model.Patient;

import java.util.List;

public class PatientHistoryMapper {

    public static PatientHistoryDTO toDTO(
            Patient patient,
            List<AppointmentNServicesDTO> appointments,
            List<PatientAllergyRecordDTO> allergies) {
        if (patient == null) return null;
        return new PatientHistoryDTO(
                PatientMapper.toDTO(patient),
                appointments,
                allergies
                );
    }
}
