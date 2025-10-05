package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "service_categories")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClinicServiceCategory {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClinicService> clinicServices = new HashSet<>();
}
