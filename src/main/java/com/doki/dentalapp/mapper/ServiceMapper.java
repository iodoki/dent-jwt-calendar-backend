package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.ServiceSlimDTO;
import com.doki.dentalapp.model.ClinicService;

public class ServiceMapper {

    public static ServiceSlimDTO toSlimDTO(ClinicService service) {
        return new ServiceSlimDTO(
                service.getId(),
                service.getName(),
                service.getCurrency(),
                service.getPrice()
        );
    }
}

