package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.ClinicServiceCategoryDTO;
import com.doki.dentalapp.service.ClinicServiceCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/service-categories")
@CrossOrigin(origins = "http://localhost:5000")
public class ClinicServiceCategoryController {

    private final ClinicServiceCategoryService service;

    public ClinicServiceCategoryController(ClinicServiceCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClinicServiceCategoryDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicServiceCategoryDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClinicServiceCategoryDTO> create(@RequestBody ClinicServiceCategoryDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicServiceCategoryDTO> update(@PathVariable UUID id, @RequestBody ClinicServiceCategoryDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
