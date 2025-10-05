package com.example.dentalapp.service;

import com.example.dentalapp.dto.DoctorDTO;
import java.util.List;
import java.util.UUID;

public interface DoctorService {
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO updateDoctor(UUID id, DoctorDTO doctorDTO);
    void deleteDoctor(UUID id);
    DoctorDTO getDoctorById(UUID id);
    List<DoctorDTO> getAllDoctors();
}
