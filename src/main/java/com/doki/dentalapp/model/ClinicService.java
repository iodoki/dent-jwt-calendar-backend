package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "services")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClinicService {

    // Getters and setters
    @Setter
    @Getter
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ClinicServiceCategory category;
}
