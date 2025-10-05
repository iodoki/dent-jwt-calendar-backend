package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentPatientServiceRecordDTO;

import java.util.List;
import java.util.UUID;

public interface AppointmentPatientServiceRecordService {
    AppointmentPatientServiceRecordDTO create(AppointmentPatientServiceRecordDTO dto);
    AppointmentPatientServiceRecordDTO get(UUID appointmentId, UUID patientServiceId);
    List<AppointmentPatientServiceRecordDTO> getAll();
    void delete(UUID appointmentId, UUID patientServiceId);
}
