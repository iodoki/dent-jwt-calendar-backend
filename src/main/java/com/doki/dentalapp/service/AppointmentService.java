package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO dto);
    AppointmentDTO getAppointment(UUID id);
    AppointmentDTO updateAppointment(UUID id, AppointmentDTO dto);
    void deleteAppointment(UUID id);
    public List<AppointmentDTO> findAppointmentsByClinicAndStartEndDateBetween(LocalDate startDate, LocalDate endDate, String view);
    public List<AppointmentDTO> findAppointmentsByClinicAndGivenDate(LocalDate date);
    public List<AppointmentDTO> findAppointmentsByPatient(UUID patientId);

}
