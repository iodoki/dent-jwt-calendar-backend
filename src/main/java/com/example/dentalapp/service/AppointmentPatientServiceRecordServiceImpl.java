package com.example.dentalapp.service;


import com.example.dentalapp.dto.AppointmentPatientServiceRecordDTO;
import com.example.dentalapp.model.Appointment;
import com.example.dentalapp.model.AppointmentPatientServiceRecord;
import com.example.dentalapp.model.AppointmentPatientServiceRecordId;
import com.example.dentalapp.model.PatientServiceRecord;
import com.example.dentalapp.mapper.AppointmentPatientServiceRecordMapper;
import com.example.dentalapp.repository.AppointmentPatientServiceRecordRepository;
import com.example.dentalapp.repository.AppointmentRepository;
import com.example.dentalapp.repository.PatientServiceRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentPatientServiceRecordServiceImpl implements AppointmentPatientServiceRecordService {

    private final AppointmentPatientServiceRecordRepository repository;
    private final AppointmentRepository appointmentRepository;
    private final PatientServiceRecordRepository patientServiceRecordRepository;

    @Override
    public AppointmentPatientServiceRecordDTO create(AppointmentPatientServiceRecordDTO dto) {
        Appointment appointment = appointmentRepository.findById(dto.appointmentId())
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        PatientServiceRecord patientService = patientServiceRecordRepository.findById(dto.patientServiceId())
                .orElseThrow(() -> new RuntimeException("PatientServiceRecord not found"));

        AppointmentPatientServiceRecord entity = AppointmentPatientServiceRecordMapper.toEntity(dto, appointment, patientService);
        return AppointmentPatientServiceRecordMapper.toDTO(repository.save(entity));
    }

    @Override
    public AppointmentPatientServiceRecordDTO get(UUID appointmentId, UUID patientServiceId) {
        return repository.findById(new AppointmentPatientServiceRecordId(appointmentId, patientServiceId))
                .map(AppointmentPatientServiceRecordMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<AppointmentPatientServiceRecordDTO> getAll() {
        return repository.findAll().stream()
                .map(AppointmentPatientServiceRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID appointmentId, UUID patientServiceId) {
        repository.deleteById(new AppointmentPatientServiceRecordId(appointmentId, patientServiceId));
    }
}
