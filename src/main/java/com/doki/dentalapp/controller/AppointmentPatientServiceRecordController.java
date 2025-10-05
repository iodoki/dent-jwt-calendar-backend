package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.AppointmentPatientServiceRecordDTO;
import com.doki.dentalapp.service.AppointmentPatientServiceRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointment-patient-service-record")
@RequiredArgsConstructor
public class AppointmentPatientServiceRecordController {

    private final AppointmentPatientServiceRecordService service;

    @PostMapping
    public ResponseEntity<AppointmentPatientServiceRecordDTO> create(@RequestBody AppointmentPatientServiceRecordDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentPatientServiceRecordDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{appointmentId}/{patientServiceId}")
    public ResponseEntity<AppointmentPatientServiceRecordDTO> get(@PathVariable UUID appointmentId,
                                                                  @PathVariable UUID patientServiceId) {
        return ResponseEntity.ok(service.get(appointmentId, patientServiceId));
    }

    @DeleteMapping("/{appointmentId}/{patientServiceId}")
    public ResponseEntity<Void> delete(@PathVariable UUID appointmentId,
                                       @PathVariable UUID patientServiceId) {
        service.delete(appointmentId, patientServiceId);
        return ResponseEntity.noContent().build();
    }
}
