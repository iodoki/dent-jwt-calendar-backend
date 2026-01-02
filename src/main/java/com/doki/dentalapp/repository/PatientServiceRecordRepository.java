package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.model.PatientServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientServiceRecordRepository extends JpaRepository<PatientServiceRecord, UUID> {
    List<PatientServiceRecord> findAllByPatient_Id(UUID patientId);

    List<PatientServiceRecord> findAllByAppointment_Id(UUID appointmentId);

    Optional<PatientServiceRecord> findByPatient_IdAndService_IdAndAppointment_Id(UUID patientId, UUID serviceId, UUID appointmentId);

    List<PatientServiceRecord> findAllByAppointment_IdAndPatient_Id(UUID appointmentId, UUID patientId);

    @Query("""
                SELECT ps.service
                FROM PatientServiceRecord ps
                WHERE ps.appointment.id = :appointmentId
            """)
    List<ClinicService> findServicesByAppointmentId(UUID appointmentId);
}
