package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.AppointmentDTO;
import com.doki.dentalapp.dto.ClinicServiceDTO;
import com.doki.dentalapp.dto.DoctorDTO;
import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.model.Doctor;
import com.doki.dentalapp.model.Patient;

import java.util.Collections;
import java.util.List;

public class AppointmentMapper {

    public static AppointmentDTO toDTO(Appointment appointment) {
        if (appointment == null) return null;
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getStartTime().toLocalDate(),
                DoctorMapper.toDTO(appointment.getDoctor()),
                PatientMapper.toDTO(appointment.getPatient()),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getStatus(),
                "Nan",
                appointment.getNote()
        );
    }

    public static Appointment toEntity(AppointmentDTO dto, Doctor doctor, Patient patient, Clinic clinic) {
        if (dto == null) return null;
        Appointment appointment = new Appointment();
        appointment.setId(dto.id());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStartTime(dto.startTime());
        appointment.setEndTime(dto.endTime());
        appointment.setStatus(dto.status());
        appointment.setNote(dto.note());
        appointment.setClinic(clinic);
        return appointment;
    }
}
