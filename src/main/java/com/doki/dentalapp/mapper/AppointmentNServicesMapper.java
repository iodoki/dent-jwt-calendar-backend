package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.AppointmentDTO;
import com.doki.dentalapp.dto.AppointmentNServicesDTO;
import com.doki.dentalapp.dto.ServiceNCategoryDTO;
import com.doki.dentalapp.model.*;

import java.util.Collections;
import java.util.List;

public class AppointmentNServicesMapper {

    public static AppointmentNServicesDTO toDTO(Appointment appointment, List<ServiceNCategoryDTO> serviceNCategories) {
        if (appointment == null) return null;
        return new AppointmentNServicesDTO(
                appointment.getId(),
                appointment.getPatient().getFirstName() + " "+ appointment.getPatient().getLastName(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getStartTime().toLocalDate(),
                appointment.getStatus(),
                DoctorMapper.toDTO(appointment.getDoctor()),
                PatientMapper.toDTO(appointment.getPatient()),
                serviceNCategories,
                appointment.getNotes()
                );
    }
}
