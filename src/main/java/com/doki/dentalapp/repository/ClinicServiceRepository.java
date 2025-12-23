package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.ClinicService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ClinicServiceRepository extends JpaRepository<ClinicService, UUID> {
    @Query(""" 
            SELECT
                s.id AS service_id,
                s.name AS service_name,
                sc.name AS category_name,
                s.price
            FROM ClinicService s
            JOIN ClinicServiceCategory sc
                ON s.category.id = sc.id
            WHERE s.clinic.id = :clinicId
            """)
    List<ClinicService> findAllWithCategoryByClinic(UUID clinicId);

    List<ClinicService> findByClinic_IdAndCategory_Id(UUID clinicId, UUID categoryId);

}
