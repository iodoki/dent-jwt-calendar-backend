package com.example.dentalapp.mapper;

import com.example.dentalapp.dto.AppointmentPatientServiceRecordDTO;
import com.example.dentalapp.model.Appointment;
import com.example.dentalapp.model.AppointmentPatientServiceRecord;
import com.example.dentalapp.model.PatientServiceRecord;

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
