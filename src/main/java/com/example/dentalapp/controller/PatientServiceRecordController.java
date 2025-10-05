package com.example.dentalapp.controller;

import com.example.dentalapp.dto.PatientServiceRecordDTO;
import com.example.dentalapp.service.PatientRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patient-service-records")
@RequiredArgsConstructor
public class PatientServiceRecordController {

    private final PatientRecordService service;

    @PostMapping
    public ResponseEntity<PatientServiceRecordDTO> create(@RequestBody PatientServiceRecordDTO dto) {
        return ResponseEntity.ok(service.createRecord(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientServiceRecordDTO> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getRecord(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientServiceRecordDTO>> getAll() {
        return ResponseEntity.ok(service.getAllRecords());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientServiceRecordDTO> update(@PathVariable UUID id, @RequestBody PatientServiceRecordDTO dto) {
        return ResponseEntity.ok(service.updateRecord(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
