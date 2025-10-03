package com.example.dentalapp.repository;

import com.example.dentalapp.entity.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, UUID> {
}
