package com.doki.dentalapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PatientServiceRecordDTO (
        UUID id,
        UUID patientId,
        UUID serviceId,
        String description,
        LocalDateTime date,
        UUID appointmentId
) {}