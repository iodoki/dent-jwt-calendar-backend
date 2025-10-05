package com.example.dentalapp.service;

import com.example.dentalapp.dto.PatientServiceRecordDTO;

import java.util.List;
import java.util.UUID;

public interface PatientRecordService {
    PatientServiceRecordDTO createRecord(PatientServiceRecordDTO dto);
    PatientServiceRecordDTO getRecord(UUID id);
    List<PatientServiceRecordDTO> getAllRecords();
    PatientServiceRecordDTO updateRecord(UUID id, PatientServiceRecordDTO dto);
    void deleteRecord(UUID id);
}
