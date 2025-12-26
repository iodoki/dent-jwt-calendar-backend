package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.ServiceNCategoryDTO;
import com.doki.dentalapp.exeption.*;
import com.doki.dentalapp.mapper.ServiceNCategoryMapper;
import com.doki.dentalapp.model.*;
import com.doki.dentalapp.repository.*;
import com.doki.dentalapp.security.MyJwtAuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HelperServiceImpl implements HelperService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ClinicServiceRepository serviceRepository;
    private final ClinicRepository clinicRepository;
    private final PatientService patientService;
    private final PatientServiceRecordRepository patientServiceRecordRepository;
    private final AppointmentPatientServiceRecordRepository appointmentPatientServiceRecordRepository;

    @Override
    public Doctor findDoctor(UUID doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() ->
                        new DoctorNotFoundException(doctorId)
                );
    }

    @Override
    public Clinic resolveClinicFromSecurity() {
        MyJwtAuthenticationToken auth =
                (MyJwtAuthenticationToken) SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        UUID clinicId = UUID.fromString(auth.getClinicId());

        return clinicRepository.findById(clinicId)
                .orElseThrow(() -> new ClinicNotFoundException(clinicId));
    }

    @Override
    public Appointment findAppointment(UUID appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                        new AppointmentNotFoundException(appointmentId)
                );
    }

    @Override
    public PatientServiceRecord findAppointmentPatientServiceRecord(Patient patient, UUID serviceId, UUID appointmentId) {
        return patientServiceRecordRepository.findByPatient_IdAndService_IdAndAppointment_Id(patient.getId(), serviceId, appointmentId)
                .orElseThrow(() ->
                        new AppointmentNPatientServiceRecordNotFoundException(appointmentId, patient.getFirstName() +" "+patient.getLastName(), serviceId)
                );
    }


    @Override
    public List<ServiceNCategoryDTO> getServicesNCategoriesFromAppointmentNPatientServiceRecordByAppointmentId(UUID appointmentId) {
        List<AppointmentPatientServiceRecord> appointmentRecords = appointmentPatientServiceRecordRepository.findAllByAppointment_Id(appointmentId);

        List<PatientServiceRecord> patientRecords = appointmentRecords.stream()
                .map(AppointmentPatientServiceRecord::getPatientServiceRecord)
                .toList();

        return patientRecords.stream()
                .map(patientServiceRecord -> {
                    return ServiceNCategoryMapper.toSlimDTO(patientServiceRecord.getService(), patientServiceRecord.getDescription());
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ServiceNCategoryDTO> getServicesNCategoriesFromPatientServiceRecordByAppointmentId(UUID appointmentId) {
        List<PatientServiceRecord> patientRecords = patientServiceRecordRepository.findAllByAppointment_Id(appointmentId);

        return patientRecords.stream()
                .map(patientServiceRecord -> {
                    return ServiceNCategoryMapper.toSlimDTO(patientServiceRecord.getService(), patientServiceRecord.getDescription());
                })
                .collect(Collectors.toList());
    }



}
