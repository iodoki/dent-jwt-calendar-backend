package com.doki.dentalapp.mapper;

import com.doki.dentalapp.dto.ServiceNCategoryDTO;
import com.doki.dentalapp.model.ClinicService;

public class ServiceNCategoryMapper {
    public static ServiceNCategoryDTO toSlimDTO(
            ClinicService service,
            String description
    ) {
        return new ServiceNCategoryDTO(
                CategoryMapper.toSlimDTO(service.getCategory()),
                ServiceMapper.toSlimDTO(service),
                description
        );
    }
}
