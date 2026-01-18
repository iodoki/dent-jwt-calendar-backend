package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.ClinicDTO;
import com.doki.dentalapp.mapper.ClinicMapper;
import com.doki.dentalapp.service.ClinicService;
import com.doki.dentalapp.service.HelperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {

    private final ClinicService clinicService;
    private final HelperService helperService;

    public ClinicController(ClinicService clinicService, HelperService helperService) {
        this.clinicService = clinicService;
        this.helperService = helperService;
    }

    @GetMapping
    public List<ClinicDTO> getAll() {
        return clinicService.getAll();
    }
    @GetMapping("/current")
    public ResponseEntity<ClinicDTO> getUserId() {
        return ResponseEntity.ok(ClinicMapper.toDTO(helperService.resolveClinicFromSecurity()));
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
