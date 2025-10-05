package com.example.dentalapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient_services")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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

