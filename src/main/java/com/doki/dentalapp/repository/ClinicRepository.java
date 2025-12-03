package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClinicRepository extends JpaRepository<Clinic, UUID> {
    Optional<Clinic> findByName(String name);

    Optional<Clinic> findByTaxIdentity(String taxIdentity);

    @Query("SELECT c FROM Clinic c where c.taxIdentity = :niptTerm")
    Optional<Clinic> findByClinicTaxIdentiy(@Param("niptTerm") String niptTerm);

    @Query("SELECT c FROM Clinic c where c.name = :clinicName")
    Optional<Clinic> findByClinicName(@Param("clinicName") String clinicName);
}
