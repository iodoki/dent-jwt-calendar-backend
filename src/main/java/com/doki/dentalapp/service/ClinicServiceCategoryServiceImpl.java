package com.doki.dentalapp.service;

import com.doki.dentalapp.dto.ClinicServiceCategoryDTO;
import com.doki.dentalapp.mapper.ClinicServiceMapper;
import com.doki.dentalapp.mapper.ServiceCategoryMapper;
import com.doki.dentalapp.model.ClinicServiceCategory;
import com.doki.dentalapp.repository.ClinicServiceCategoryRepository;
import com.doki.dentalapp.security.MyJwtAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicServiceCategoryServiceImpl implements ClinicServiceCategoryService {

    private final ClinicServiceCategoryRepository repository;

    public ClinicServiceCategoryServiceImpl(ClinicServiceCategoryRepository repository) {
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

    @Override
    public List<ClinicServiceCategoryDTO> getCategoriesUsedByClinic() {
        MyJwtAuthenticationToken auth = (MyJwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return repository.findCategoriesUsedByClinic(UUID.fromString(auth.getClinicId())).stream()
                .map(ServiceCategoryMapper::toDTO)
                .toList();    }
}
