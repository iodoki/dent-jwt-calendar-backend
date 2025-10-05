package com.example.dentalapp.service;


import com.example.dentalapp.dto.ClinicServiceDTO;
import com.example.dentalapp.mapper.ClinicServiceMapper;
import com.example.dentalapp.model.Clinic;
import com.example.dentalapp.model.ClinicService;
import com.example.dentalapp.model.ClinicServiceCategory;
import com.example.dentalapp.repository.ClinicRepository;
import com.example.dentalapp.repository.ClinincServiceCategoryRepository;
import com.example.dentalapp.repository.ClinicServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ClinicServiceServiceImpl implements ClinicServiceService {

    private final ClinicServiceRepository clinicServiceRepository;
    private final ClinicRepository clinicRepository;
    private final ClinincServiceCategoryRepository categoryRepository;

    public ClinicServiceServiceImpl(ClinicServiceRepository clinicServiceRepository,
                                    ClinicRepository clinicRepository,
                                    ClinincServiceCategoryRepository categoryRepository) {
        this.clinicServiceRepository = clinicServiceRepository;
        this.clinicRepository = clinicRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ClinicServiceDTO> getAll() {
        return clinicServiceRepository.findAll().stream()
                .map(ClinicServiceMapper::toDTO)
                .toList();
    }

    @Override
    public ClinicServiceDTO getById(UUID id) {
        ClinicService service = clinicServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return ClinicServiceMapper.toDTO(service);
    }

    @Override
    public ClinicServiceDTO create(ClinicServiceDTO dto) {
        Clinic clinic = clinicRepository.findById(dto.clinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
        ClinicServiceCategory category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        ClinicService service = ClinicServiceMapper.toEntity(dto, clinic, category);
        return ClinicServiceMapper.toDTO(clinicServiceRepository.save(service));
    }

    @Override
    public ClinicServiceDTO update(UUID id, ClinicServiceDTO dto) {
        ClinicService existing = clinicServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        existing.setName(dto.name());
        existing.setPrice(dto.price());
        existing.setClinic(clinicRepository.findById(dto.clinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found")));
        existing.setCategory(categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));

        return ClinicServiceMapper.toDTO(clinicServiceRepository.save(existing));
    }

    @Override
    public void delete(UUID id) {
        clinicServiceRepository.deleteById(id);
    }
}
