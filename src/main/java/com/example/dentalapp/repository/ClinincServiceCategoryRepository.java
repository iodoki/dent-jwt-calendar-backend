package com.example.dentalapp.repository;

import com.example.dentalapp.model.ClinicServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClinincServiceCategoryRepository extends JpaRepository<ClinicServiceCategory, UUID> {
}
