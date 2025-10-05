package com.doki.dentalapp.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

public record AppointmentDTO(
        UUID id,
        UUID doctorId,
        UUID patientId,
        UUID serviceId,
        OffsetDateTime startTime,
        OffsetDateTime endTime,
        String status,
        String notes,
        UUID clinicId
){}