package com.example.dentalapp.repository;

import com.example.dentalapp.model.PatientServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface PatientServiceRecordRepository extends JpaRepository<PatientServiceRecord, UUID> {
    List<PatientServiceRecord> findByPatientId(UUID patientId);
}
