package com.doki.dentalapp.dto;

import jakarta.validation.constraints.Size;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record AppointmentDTO(
        UUID id,
        LocalDate date,
        DoctorDTO doctor,
        PatientDTO patient,
        OffsetDateTime startTime,
        OffsetDateTime endTime,
        String status,
        String description,
        @Size(max = 10000)
        String note
){}