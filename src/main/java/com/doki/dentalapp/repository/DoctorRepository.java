package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    List<Doctor> findAllByClinic_Id(UUID clinicId);
    @Query("SELECT d FROM Doctor d WHERE d.clinic.id = :clinicId")
    List<Doctor> getDoctors(@Param("clinicId") UUID clinicId);

//    @Query("SELECT d FROM Doctor d WHERE d.clinic.id = :clinicId")
//    List<Doctor> findDoctorsByClinicId(@Param("clinicId") UUID clinicId);

}
