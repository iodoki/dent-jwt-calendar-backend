package com.example.dentalapp.repository;

import com.example.dentalapp.model.AppointmentService;
import com.example.dentalapp.model.AppointmentServiceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentServiceRepository extends JpaRepository<AppointmentService, AppointmentServiceId> {
}
