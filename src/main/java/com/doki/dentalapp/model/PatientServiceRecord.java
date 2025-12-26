package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient_services")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PatientServiceRecord {

    // Getters and setters
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id")
    private ClinicService service;

    @Column(name = "description", length = 50, nullable = false)
    private String description; // e.g., For tooth number "11", "26", "47"

    @Column(name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "active")
    private Boolean active;
}

