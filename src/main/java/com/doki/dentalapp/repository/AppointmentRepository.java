package com.doki.dentalapp.repository;


import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    @Query("""
                SELECT a FROM Appointment a
                WHERE a.clinic.id = :clinicId
                  AND a.startTime BETWEEN :startTime AND :endTime
                  AND a.active = true
                  ORDER BY a.startTime ASC
            """)
    List<Appointment> findByClinicIdAndStartEndTimeBetween(
            @Param("clinicId") UUID clinicId,
            @Param("startTime") OffsetDateTime startTime,
            @Param("endTime") OffsetDateTime endTime
    );


    @Query("""
            SELECT a FROM Appointment a 
            JOIN FETCH a.patient 
            WHERE a.clinic.id = :clinicId AND a.startTime BETWEEN :start AND :end
            """)
    List<Appointment> findAppointmentsWithPatient(@Param("clinicId") UUID clinicId, @Param("start") OffsetDateTime start, @Param("end") OffsetDateTime end);


    @Query("""
                SELECT a FROM Appointment a
                WHERE a.clinic.id = :clinicId
                  AND a.patient.id = :patientId
                  ORDER by createdAt DESC
            """)
    List<Appointment> findAppointmentsByPatient(
            @Param("clinicId") UUID clinicId,
            @Param("patientId") UUID patientId
    );

    List<Appointment> findByStartTimeBetween(OffsetDateTime startTime, OffsetDateTime endTime);

    // List<Appointment> findAppointmentsByPatient(Patient patient);

    List<Appointment> findByClinic_IdAndStartTimeBetween(UUID clinicId, OffsetDateTime startTime, OffsetDateTime endTime);

}
