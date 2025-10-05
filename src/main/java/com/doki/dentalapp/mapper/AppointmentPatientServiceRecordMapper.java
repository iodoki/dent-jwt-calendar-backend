package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.AppointmentPatientServiceRecordDTO;
import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.model.AppointmentPatientServiceRecord;
import com.doki.dentalapp.model.PatientServiceRecord;

public class AppointmentPatientServiceRecordMapper {

    public static AppointmentPatientServiceRecordDTO toDTO(AppointmentPatientServiceRecord entity) {
        if (entity == null) return null;
        return new AppointmentPatientServiceRecordDTO(
                entity.getAppointment().getId(),
                entity.getPatientServiceRecord().getId()
        );
    }

    public static AppointmentPatientServiceRecord toEntity(AppointmentPatientServiceRecordDTO dto,
                                                           Appointment appointment,
                                                           PatientServiceRecord patientServiceRecord) {
        if (dto == null) return null;
        AppointmentPatientServiceRecord entity = new AppointmentPatientServiceRecord();
        entity.setAppointment(appointment);
        entity.setPatientServiceRecord(patientServiceRecord);
        return entity;
    }
}
