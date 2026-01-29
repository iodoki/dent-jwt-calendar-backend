package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentDTO;
import com.doki.dentalapp.dto.AppointmentNServicesDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    AppointmentNServicesDTO createAppointment(AppointmentNServicesDTO dto);
    AppointmentNServicesDTO getAppointment(UUID id);
    AppointmentNServicesDTO updateAppointment(UUID id, AppointmentNServicesDTO dto);
    void deleteAppointment(UUID id);
    List<AppointmentNServicesDTO> findAppointmentsByClinicAndStartEndDateBetween(LocalDate startDate, LocalDate endDate, String view);
    List<AppointmentNServicesDTO> findAppointmentsByClinicAndGivenDate(LocalDate date);
    void updateAppointmentNotes(UUID id, String notes);

}
