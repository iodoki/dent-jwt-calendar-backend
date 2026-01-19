package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Patient {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "father_name", length = 50, nullable = false)
    private String fatherName;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Builder.Default
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName = "defaultValue";

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    // getters & setters
    @Column(name = "active")
    private Boolean active;

    @Column(name = "gender", length = 50, nullable = false)
    private String gender;

    @Column(name = "profession", length = 50, nullable = false)
    private String profession;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "identity_number", length = 50, nullable = false)
    private String identityNumber;

    @Column(name = "health_care_number", length = 50, nullable = false)
    private String healthCareNumber;
    // getters & setters
}

