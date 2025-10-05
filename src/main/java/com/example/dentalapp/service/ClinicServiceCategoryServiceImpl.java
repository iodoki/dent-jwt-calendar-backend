package com.example.dentalapp.service;

import com.example.dentalapp.dto.ClinicServiceCategoryDTO;
import com.example.dentalapp.mapper.ServiceCategoryMapper;
import com.example.dentalapp.model.ClinicServiceCategory;
import com.example.dentalapp.repository.ClinincServiceCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicServiceCategoryServiceImpl implements ClinicServiceCategoryService {

    private final ClinincServiceCategoryRepository repository;

    public ClinicServiceCategoryServiceImpl(ClinincServiceCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClinicServiceCategoryDTO> getAll() {
        return repository.findAll().stream()
                .map(ServiceCategoryMapper::toDTO)
                .toList();
    }

    @Override
    public ClinicServiceCategoryDTO getById(UUID id) {
        return repository.findById(id)
                .map(ServiceCategoryMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ServiceCategory not found"));
    }

    @Override
    public ClinicServiceCategoryDTO create(ClinicServiceCategoryDTO dto) {
        ClinicServiceCategory entity = ServiceCategoryMapper.toEntity(dto);
        return ServiceCategoryMapper.toDTO(repository.save(entity));
    }

    @Override
    public ClinicServiceCategoryDTO update(UUID id, ClinicServiceCategoryDTO dto) {
        ClinicServiceCategory existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceCategory not found"));
        existing.setName(dto.name());
        existing.setDescription(dto.description());
        return ServiceCategoryMapper.toDTO(repository.save(existing));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
