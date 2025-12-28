package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.ClinicUserDTO;
import com.doki.dentalapp.service.ClinicUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clinic-users")
@RequiredArgsConstructor
public class ClinicUserController {

    private final ClinicUserService service;

    @PostMapping
    public ResponseEntity<ClinicUserDTO> create(@RequestBody ClinicUserDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClinicUserDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{clinicId}/{userId}")
    public ResponseEntity<ClinicUserDTO> get(@PathVariable UUID clinicId,
                                                                  @PathVariable UUID userId) {
        return ResponseEntity.ok(service.get(clinicId, userId));
    }


    @DeleteMapping("/{clinicId}/{userId}")
    public ResponseEntity<Void> delete(@PathVariable UUID clinicId,
                                       @PathVariable UUID userId) {
        service.delete(clinicId, userId);
        return ResponseEntity.noContent().build();
    }
}
