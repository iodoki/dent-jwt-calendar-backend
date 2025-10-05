package com.doki.dentalapp.service;
import com.doki.dentalapp.dto.PatientServiceRecordDTO;
import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.model.Patient;
import com.doki.dentalapp.model.PatientServiceRecord;
import com.doki.dentalapp.mapper.PatientServiceRecordMapper;
import com.doki.dentalapp.repository.ClinicServiceRepository;
import com.doki.dentalapp.repository.PatientRepository;
import com.doki.dentalapp.repository.PatientServiceRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class PatientRecordServiceImpl implements PatientRecordService {

    private final PatientServiceRecordRepository recordRepository;
    private final PatientRepository patientRepository;
    private final ClinicServiceRepository serviceRepository;

    @Override
    public PatientServiceRecordDTO createRecord(PatientServiceRecordDTO dto) {
        Patient patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        ClinicService service = serviceRepository.findById(dto.serviceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        PatientServiceRecord record = PatientServiceRecordMapper.toEntity(dto, patient, service);
        return PatientServiceRecordMapper.toDTO(recordRepository.save(record));
    }

    @Override
    public PatientServiceRecordDTO getRecord(UUID id) {
        return recordRepository.findById(id)
                .map(PatientServiceRecordMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<PatientServiceRecordDTO> getAllRecords() {
        return recordRepository.findAll().stream()
                .map(PatientServiceRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientServiceRecordDTO updateRecord(UUID id, PatientServiceRecordDTO dto) {
        PatientServiceRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        Patient patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        ClinicService service = serviceRepository.findById(dto.serviceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        record.setPatient(patient);
        record.setService(service);
        record.setDescription(dto.description());
        record.setDate(dto.date());

        return PatientServiceRecordMapper.toDTO(recordRepository.save(record));
    }

    @Override
    public void deleteRecord(UUID id) {
        recordRepository.deleteById(id);
    }
}