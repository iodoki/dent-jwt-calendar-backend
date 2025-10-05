package com.example.dentalapp.service;


import com.example.dentalapp.dto.PatientDTO;
import com.example.dentalapp.mapper.PatientMapper;
import com.example.dentalapp.model.Clinic;
import com.example.dentalapp.model.Patient;
import com.example.dentalapp.model.User;
import com.example.dentalapp.repository.ClinicRepository;
import com.example.dentalapp.repository.PatientRepository;
import com.example.dentalapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    public List<PatientDTO> getAll();
    public PatientDTO getById(UUID id);
    public PatientDTO create(PatientDTO dto);
    public PatientDTO update(UUID id, PatientDTO dto);
    public void delete(UUID id);
}
