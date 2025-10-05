package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.ClinicDTO;
import com.doki.dentalapp.service.ClinicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clinics")
@CrossOrigin(origins = "http://localhost:5173")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public List<ClinicDTO> getAll() {
        return clinicService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(clinicService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClinicDTO> create(@RequestBody ClinicDTO dto) {
        return ResponseEntity.ok(clinicService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicDTO> update(@PathVariable UUID id, @RequestBody ClinicDTO dto) {
        return ResponseEntity.ok(clinicService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        clinicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
