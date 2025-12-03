package com.doki.dentalapp.repository;


import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    @Query("""
                SELECT ap.id, ap.status, ap.notes FROM Appointment ap
            """)
    List<Appointment> findAllWithAppointmentDetails();

    List<Appointment> findByStartTimeBetween(OffsetDateTime startTime, OffsetDateTime endTime);

    List<Appointment> findAppointmentsByPatient(Patient patient);

}
