package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.ClinicService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ClinicServiceRepository extends JpaRepository<ClinicService, UUID> {
    List<ClinicService> findByCategoryId(UUID categoryId);
    List<ClinicService> findByCategoryName(String  name);
}
