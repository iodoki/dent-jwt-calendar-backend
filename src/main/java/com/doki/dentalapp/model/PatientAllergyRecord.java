package com.doki.dentalapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient_allergy_record")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PatientAllergyRecord {

    // Getters and setters
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "allergy_question_id")
    private AllergyQuestion allergyQuestion;

    @Column(name = "has_past_record")
    private Boolean hasPastRecord;

    @Column(columnDefinition = "TEXT", length = 500)
    private String note;



}

