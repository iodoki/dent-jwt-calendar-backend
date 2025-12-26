package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.AppointmentNServicesDTO;
import com.doki.dentalapp.dto.PatientHistoryDTO;
import com.doki.dentalapp.dto.ServiceNCategoryDTO;
import com.doki.dentalapp.exeption.AppointmentNotFoundException;
import com.doki.dentalapp.mapper.ServiceNCategoryMapper;
import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.model.AppointmentPatientServiceRecord;
import com.doki.dentalapp.model.PatientServiceRecord;
import com.doki.dentalapp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentNPatientServiceHistoryImpl implements AppointmentNPatientServiceHistory {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ClinicServiceRepository serviceRepository;
    private final ClinicRepository clinicRepository;
    private final PatientService patientService;
    private final PatientServiceRecordRepository patientServiceRecordRepository;
    private final AppointmentPatientServiceRecordRepository appointmentPatientServiceRecordRepository;

    public List<ServiceNCategoryDTO> getAppointmentServices(UUID appointmentId) {

        List<PatientServiceRecord> records = getPatientServiceRecordByAppointmentId(appointmentId);

        return records.stream()
                .map(patientServiceRecord -> {
                    return ServiceNCategoryMapper.toSlimDTO(patientServiceRecord.getService(), patientServiceRecord.getDescription());
                })
                .collect(Collectors.toList());
    }


    private Appointment findAppointment(UUID appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                        new AppointmentNotFoundException(appointmentId)
                );
    }

    private List<PatientServiceRecord> getPatientServiceRecordByAppointmentId(UUID appointmentId) {
        List<AppointmentPatientServiceRecord> records = appointmentPatientServiceRecordRepository.findAllByAppointment_Id(appointmentId);

        return records.stream()
                .map(AppointmentPatientServiceRecord::getPatientServiceRecord)
                .collect(Collectors.toList());
    }

}
