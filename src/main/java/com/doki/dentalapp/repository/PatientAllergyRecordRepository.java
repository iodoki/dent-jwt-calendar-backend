package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.PatientAllergyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientAllergyRecordRepository extends JpaRepository<PatientAllergyRecord, UUID> {
    List<PatientAllergyRecord> findAllByPatient_Id(UUID patientId);
    boolean existsByPatient_IdAndAllergyQuestion_Id(
            UUID patientId,
            UUID allergyQuestionId
    );
    Optional<PatientAllergyRecord>
    findByPatient_IdAndAllergyQuestion_Id(UUID patientId, UUID allergyQuestionId);

}
