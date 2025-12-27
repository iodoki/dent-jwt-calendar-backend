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
                clinic.getTaxIdentity(),
                clinic.getLeftTitle(),
                clinic.getRightTitle()
        );
    }

    public static Clinic toEntity(ClinicDTO dto) {
        Clinic clinic = new Clinic();
        clinic.setId(dto.id());
        clinic.setName(dto.name());
        clinic.setAddress(dto.address());
        clinic.setPhone(dto.phone());
        clinic.setEmail(dto.email());
        clinic.setTaxIdentity(dto.nipt());
        clinic.setLeftTitle(dto.leftTitle());
        clinic.setRightTitle(dto.rightTitle());
        return clinic;
    }
}
