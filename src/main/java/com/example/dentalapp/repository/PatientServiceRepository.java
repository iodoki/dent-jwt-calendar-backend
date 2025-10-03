package com.example.dentalapp.repository;

import com.example.dentalapp.entity.PatientService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface PatientServiceRepository extends JpaRepository<PatientService, UUID> {
    List<PatientService> findByPatientId(UUID patientId);
}
