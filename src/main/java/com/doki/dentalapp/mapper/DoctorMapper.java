package com.doki.dentalapp.mapper;


import com.doki.dentalapp.dto.DoctorDTO;
import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.model.Doctor;
import com.doki.dentalapp.model.User;

public class DoctorMapper {

    public static DoctorDTO toDTO(Doctor Doctor) {
        return new DoctorDTO(
                Doctor.getId(),
                Doctor.getUser() != null ? Doctor.getUser().getId() : null,
                Doctor.getClinic() != null ? Doctor.getClinic().getId() : null,
                Doctor.getSpecialty(),
                Doctor.getFirstName(),
                Doctor.getLastName(),
                Doctor.getFullName()
        );
    }

    public static Doctor toEntity(DoctorDTO dto, Clinic clinic, User user) {
        return Doctor.builder()
                .id(dto.id())
                .user(user)
                .clinic(clinic)
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .fullName(dto.fullName())
                .build();
    }
}
