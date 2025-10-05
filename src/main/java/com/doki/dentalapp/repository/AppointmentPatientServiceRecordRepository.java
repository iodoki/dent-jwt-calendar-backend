package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.AppointmentPatientServiceRecord;
import com.doki.dentalapp.model.AppointmentPatientServiceRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentPatientServiceRecordRepository extends JpaRepository<AppointmentPatientServiceRecord, AppointmentPatientServiceRecordId> {
}
