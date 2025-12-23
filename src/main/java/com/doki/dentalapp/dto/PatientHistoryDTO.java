package com.doki.dentalapp.dto;

import java.util.List;

public record PatientHistoryDTO(
        PatientDTO patientDTO,
        List<AllergyRecordDTO> allergyRecordDTOS,
        List<AppointmentServiceHistoryDTO> appointmentServiceHistoryDTOS

        ) {}
