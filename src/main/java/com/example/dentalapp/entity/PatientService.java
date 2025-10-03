package com.example.dentalapp.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "patient_services")
public class PatientService {

    // Getters and setters
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "description", length = 50, nullable = false)
    private String description; // e.g., For tooth number "11", "26", "47"

    @Column(name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now();
}

