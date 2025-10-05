package com.example.dentalapp.service;

import com.example.dentalapp.dto.AppointmentDTO;
import com.example.dentalapp.model.Appointment;
import com.example.dentalapp.model.Clinic;
import com.example.dentalapp.model.ClinicService;
import com.example.dentalapp.model.Doctor;
import com.example.dentalapp.model.Patient;
import com.example.dentalapp.mapper.AppointmentMapper;
import com.example.dentalapp.repository.AppointmentRepository;
import com.example.dentalapp.repository.ClinicRepository;
import com.example.dentalapp.repository.ClinicServiceRepository;
import com.example.dentalapp.repository.DoctorRepository;
import com.example.dentalapp.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ClinicServiceRepository serviceRepository;
    private final ClinicRepository clinicRepository;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO dto) {
        Doctor doctor = doctorRepository.findById(dto.doctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        ClinicService service = serviceRepository.findById(dto.serviceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));
        Clinic clinic = clinicRepository.findById(dto.clinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        Appointment appointment = AppointmentMapper.toEntity(dto, doctor, patient, service, clinic);
        return AppointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentDTO getAppointment(UUID id) {
        return appointmentRepository.findById(id)
                .map(AppointmentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO updateAppointment(UUID id, AppointmentDTO dto) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Doctor doctor = doctorRepository.findById(dto.doctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        ClinicService service = serviceRepository.findById(dto.serviceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));
        Clinic clinic = clinicRepository.findById(dto.clinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setService(service);
        appointment.setClinic(clinic);
        appointment.setStartTime(dto.startTime());
        appointment.setEndTime(dto.endTime());
        appointment.setStatus(dto.status());
        appointment.setNotes(dto.notes());

        return AppointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    @Override
    public void deleteAppointment(UUID id) {
        appointmentRepository.deleteById(id);
    }
}
