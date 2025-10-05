package com.example.dentalapp.mapper;

import com.example.dentalapp.dto.ClinicServiceDTO;
import com.example.dentalapp.model.Clinic;
import com.example.dentalapp.model.ClinicService;
import com.example.dentalapp.model.ClinicServiceCategory;

public class ClinicServiceMapper {

    public static ClinicServiceDTO toDTO(ClinicService clinicService) {
        return new ClinicServiceDTO(
                clinicService.getId(),
                clinicService.getName(),
                clinicService.getPrice(),
                clinicService.getClinic() != null ? clinicService.getClinic().getId() : null,
                clinicService.getCategory() != null ? clinicService.getCategory().getId() : null
        );
    }

    public static ClinicService toEntity(ClinicServiceDTO dto, Clinic clinic, ClinicServiceCategory category) {
        ClinicService clinicService = new ClinicService();
        clinicService.setId(dto.id());
        clinicService.setName(dto.name());
        clinicService.setPrice(dto.price());
        clinicService.setClinic(clinic);
        clinicService.setCategory(category);
        return clinicService;
    }
}
