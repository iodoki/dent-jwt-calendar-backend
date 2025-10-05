package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentDTO;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO dto);
    AppointmentDTO getAppointment(UUID id);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO updateAppointment(UUID id, AppointmentDTO dto);
    void deleteAppointment(UUID id);
}
