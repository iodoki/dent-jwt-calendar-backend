package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.ClinicServiceDTO;
import com.doki.dentalapp.dto.PatientDTO;
import com.doki.dentalapp.service.ClinicServiceService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/services")
public class ClinicServiceController {

    private final ClinicServiceService service;

    public ClinicServiceController(ClinicServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClinicServiceDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicServiceDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClinicServiceDTO> create(@RequestBody ClinicServiceDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicServiceDTO> update(@PathVariable UUID id, @RequestBody ClinicServiceDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/category")
    public ResponseEntity<List<ClinicServiceDTO>> searchServicesByCategory(
            @RequestParam(required = true) UUID categoryId) {
        System.out.println("🔍 Searching service by category id: '" + categoryId + "'");
        return ResponseEntity.ok(service.getServiceByCategoryId(categoryId));
    }
}