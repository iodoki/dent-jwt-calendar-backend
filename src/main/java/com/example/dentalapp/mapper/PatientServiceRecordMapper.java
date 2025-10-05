package com.example.dentalapp.mapper;


import com.example.dentalapp.dto.PatientServiceRecordDTO;
import com.example.dentalapp.model.ClinicService;
import com.example.dentalapp.model.Patient;
import com.example.dentalapp.model.PatientServiceRecord;

public class PatientServiceRecordMapper {

    public static PatientServiceRecordDTO toDTO(PatientServiceRecord record) {
        if (record == null) return null;
        return new PatientServiceRecordDTO(
                record.getId(),
                record.getPatient().getId(),
                record.getService().getId(),
                record.getDescription(),
                record.getDate()
        );
    }

    public static PatientServiceRecord toEntity(PatientServiceRecordDTO dto, Patient patient, ClinicService service) {
        if (dto == null) return null;
        PatientServiceRecord record = new PatientServiceRecord();
        record.setId(dto.id());
        record.setPatient(patient);
        record.setService(service);
        record.setDescription(dto.description());
        record.setDate(dto.date());
        return record;
    }
}
