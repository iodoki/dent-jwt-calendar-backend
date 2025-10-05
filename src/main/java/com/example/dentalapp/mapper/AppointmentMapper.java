package com.example.dentalapp.mapper;

import com.example.dentalapp.dto.AppointmentDTO;
import com.example.dentalapp.model.Appointment;
import com.example.dentalapp.model.Clinic;
import com.example.dentalapp.model.ClinicService;
import com.example.dentalapp.model.Doctor;
import com.example.dentalapp.model.Patient;

public class AppointmentMapper {

    public static AppointmentDTO toDTO(Appointment appointment) {
        if (appointment == null) return null;
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getDoctor().getId(),
                appointment.getPatient().getId(),
                appointment.getService().getId(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getStatus(),
                appointment.getNotes(),
                appointment.getClinic().getId()
        );
    }

    public static Appointment toEntity(AppointmentDTO dto, Doctor doctor, Patient patient, ClinicService service, Clinic clinic) {
        if (dto == null) return null;
        Appointment appointment = new Appointment();
        appointment.setId(dto.id());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setService(service);
        appointment.setStartTime(dto.startTime());
        appointment.setEndTime(dto.endTime());
        appointment.setStatus(dto.status());
        appointment.setNotes(dto.notes());
        appointment.setClinic(clinic);
        return appointment;
    }
}
