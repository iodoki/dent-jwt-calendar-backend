package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.ClinicServiceDTO;
import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.model.ClinicServiceCategory;

public class ClinicServiceMapper {

    public static ClinicServiceDTO toDTO(ClinicService clinicService) {
        return new ClinicServiceDTO(
                clinicService.getId(),
                clinicService.getName(),
                clinicService.getPrice(),
                clinicService.getCurrency(),
                clinicService.getClinic() != null ? clinicService.getClinic().getId() : null,
                clinicService.getCategory() != null ? clinicService.getCategory().getId() : null,
                clinicService.getCategory() != null ? clinicService.getCategory().getName() : null

        );
    }

    public static ClinicService toEntity(ClinicServiceDTO dto, Clinic clinic, ClinicServiceCategory category) {
        ClinicService clinicService = new ClinicService();
        clinicService.setId(dto.id());
        clinicService.setName(dto.name());
        clinicService.setPrice(dto.price());
        clinicService.setCurrency(dto.currency());
        clinicService.setClinic(clinic);
        clinicService.setCategory(category);
        return clinicService;
    }
}
