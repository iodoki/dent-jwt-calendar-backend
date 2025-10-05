package com.example.dentalapp.dto;

import java.util.UUID;

public record AppointmentPatientServiceRecordDTO(
        UUID appointmentId,
        UUID patientServiceId
) {}
