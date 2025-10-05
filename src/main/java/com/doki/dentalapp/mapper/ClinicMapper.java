package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.ClinicDTO;
import com.doki.dentalapp.model.Clinic;

public class ClinicMapper {

    public static ClinicDTO toDTO(Clinic clinic) {
        return new ClinicDTO(
                clinic.getId(),
                clinic.getName(),
                clinic.getAddress(),
                clinic.getPhone(),
                clinic.getEmail(),
                clinic.getNipt()
        );
    }

    public static Clinic toEntity(ClinicDTO dto) {
        Clinic clinic = new Clinic();
        clinic.setId(dto.id());
        clinic.setName(dto.name());
        clinic.setAddress(dto.address());
        clinic.setPhone(dto.phone());
        clinic.setEmail(dto.email());
        clinic.setNipt(dto.nipt());
        return clinic;
    }
}
