package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentDTO;
import com.doki.dentalapp.model.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO dto);
    AppointmentDTO getAppointment(UUID id);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO updateAppointment(UUID id, AppointmentDTO dto);
    void deleteAppointment(UUID id);
    public List<AppointmentDTO> findAppointments(LocalDate startDate, LocalDate endDate, String view);
    public List<AppointmentDTO> findAppointmentsByDate(LocalDate date);
    public List<AppointmentDTO> findAppointmentsByPatient(UUID patientId);

}
