package com.example.dentalapp.repository;

import com.example.dentalapp.model.AppointmentPatientServiceRecord;
import com.example.dentalapp.model.AppointmentPatientServiceRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentPatientServiceRecordRepository extends JpaRepository<AppointmentPatientServiceRecord, AppointmentPatientServiceRecordId> {
}
