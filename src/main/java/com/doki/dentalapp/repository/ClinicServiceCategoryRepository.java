package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.ClinicServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicServiceCategoryRepository extends JpaRepository<ClinicServiceCategory, UUID> {
}
