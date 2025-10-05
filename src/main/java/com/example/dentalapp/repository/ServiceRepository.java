package com.example.dentalapp.repository;

import com.example.dentalapp.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
    List<Service> findByCategoryId(UUID categoryId);
    List<Service> findByCategoryName(String  name);
}
