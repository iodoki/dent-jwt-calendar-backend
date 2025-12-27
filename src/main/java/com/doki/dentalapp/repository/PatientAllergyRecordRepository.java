package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.PatientAllergyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatientAllergyRecordRepository extends JpaRepository<PatientAllergyRecord, UUID> {
    List<PatientAllergyRecord> findAllByPatient_Id(UUID patientId);
}
