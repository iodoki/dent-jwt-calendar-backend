package com.example.dentalapp.repository;

import com.example.dentalapp.entity.AppointmentService;
import com.example.dentalapp.entity.AppointmentServiceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentServiceRepository extends JpaRepository<AppointmentService, AppointmentServiceId> {
}
