package com.example.dentalapp.repository;

import com.example.dentalapp.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicRepository  extends JpaRepository<Clinic, UUID> {
}
