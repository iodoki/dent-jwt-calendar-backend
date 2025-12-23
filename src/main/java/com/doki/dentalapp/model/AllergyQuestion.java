package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "allergy_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AllergyQuestion {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

}

