package com.example.dentalapp.mapper;


import com.example.dentalapp.dto.PatientDTO;
import com.example.dentalapp.model.Clinic;
import com.example.dentalapp.model.Patient;
import com.example.dentalapp.model.User;

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
                patient.getClinic() != null ? patient.getClinic().getId() : null,
                patient.getUser() != null ? patient.getUser().getId() : null
        );
    }

    public static Patient toEntity(PatientDTO dto, Clinic clinic, User user) {
        return Patient.builder()
                .id(dto.id())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .fatherName(dto.fatherName())
                .email(dto.email())
                .phone(dto.phone())
                .dateOfBirth(dto.dateOfBirth())
                .clinic(clinic)
                .user(user)
                .build();
    }
}
