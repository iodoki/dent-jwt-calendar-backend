package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.ClinicUserDTO;
import com.doki.dentalapp.model.*;

public class ClinicUserMapper {

    public static ClinicUserDTO toDTO(ClinicUser entity) {
        if (entity == null) return null;
        return new ClinicUserDTO(
                entity.getClinic().getId(),
                entity.getUser().getId()
        );
    }

    public static ClinicUser toEntity(ClinicUserDTO dto,
                                                           Clinic clinic,
                                                           User user) {
        if (dto == null) return null;
        ClinicUser entity = new ClinicUser();
        entity.setClinic(clinic);
        entity.setUser(user);
        return entity;
    }
}
