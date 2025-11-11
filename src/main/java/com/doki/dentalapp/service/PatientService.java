package com.doki.dentalapp.service;


import com.doki.dentalapp.dto.PatientDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    public List<PatientDTO> getAll();
    public PatientDTO getById(UUID id);
    public PatientDTO create(PatientDTO dto);
    public PatientDTO update(UUID id, PatientDTO dto);
    public void delete(UUID id);
    public List<PatientDTO> search(String search, Pageable pageable);
}
