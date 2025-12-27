package com.doki.dentalapp.dto;

import jakarta.validation.constraints.Size;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record AppointmentNServicesDTO(
        UUID id,
        String title,
        OffsetDateTime startTime,
        OffsetDateTime endTime,
        LocalDate date,
        String status,
        DoctorDTO doctor,
        PatientDTO patient,
        List<ServiceNCategoryDTO> services,
        @Size(max = 10000)
        String notes
){}