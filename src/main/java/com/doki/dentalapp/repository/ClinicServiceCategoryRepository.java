package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.ClinicServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ClinicServiceCategoryRepository extends JpaRepository<ClinicServiceCategory, UUID> {
    @Query("""
                SELECT DISTINCT csc
                FROM ClinicService cs
                JOIN cs.category csc
                WHERE cs.clinic.id = :clinicId
                ORDER BY csc.name
            """)
    List<ClinicServiceCategory> findCategoriesUsedByClinic(UUID clinicId);

}
