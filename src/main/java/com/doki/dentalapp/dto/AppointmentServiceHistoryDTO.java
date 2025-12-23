package com.doki.dentalapp.dto;

import java.util.List;

public record AppointmentServiceHistoryDTO(
        AppointmentDTO appointmentDTO,
        List<PatientServiceRecordDTO> patientHistoryRecordDTOS) {

}
