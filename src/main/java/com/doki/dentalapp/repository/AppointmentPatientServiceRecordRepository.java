package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.AppointmentPatientServiceRecord;
import com.doki.dentalapp.model.AppointmentPatientServiceRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentPatientServiceRecordRepository extends JpaRepository<AppointmentPatientServiceRecord, AppointmentPatientServiceRecordId> {
List<AppointmentPatientServiceRecord> findAllByAppointment_Id(UUID id);

}
