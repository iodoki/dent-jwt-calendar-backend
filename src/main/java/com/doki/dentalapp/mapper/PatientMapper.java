package com.doki.dentalapp.mapper;


import com.doki.dentalapp.dto.PatientDTO;
import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.model.Patient;
import com.doki.dentalapp.model.User;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getFatherName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getDateOfBirth(),
                patient.getClinic() != null ? patient.getClinic().getId() : null
        );
    }

    public static Patient toEntity(PatientDTO dto, Clinic clinic) {
        return Patient.builder()
                .id(dto.id())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .fatherName(dto.fatherName())
                .email(dto.email())
                .phone(dto.phone())
                .dateOfBirth(dto.dateOfBirth())
                .clinic(clinic)
                .build();
    }
}
