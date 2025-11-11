package com.doki.dentalapp.repository;

import com.doki.dentalapp.model.ClinicService;
import com.doki.dentalapp.model.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ClinicServiceRepository extends JpaRepository<ClinicService, UUID> {
//    @Query("SELECT s.id, s.name, s.price, c.name, c.id FROM Services s\n" +
//            "JOIN service_categories c ON s.category_id = c.id")
//    List<ClinicService> findAllWithCategory();

    @Query("SELECT s FROM ClinicService s JOIN FETCH s.category")
    List<ClinicService> findAllWithCategory();
    List<ClinicService> findAllByCategoryId(UUID categoryId);

}
