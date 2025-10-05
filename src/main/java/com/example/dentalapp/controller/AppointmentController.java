
package com.example.dentalapp.controller;

import com.example.dentalapp.dto.AppointmentDTO;
import com.example.dentalapp.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    @PostMapping
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO dto) {
        return ResponseEntity.ok(service.createAppointment(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getAppointment(id));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAll() {
        return ResponseEntity.ok(service.getAllAppointments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable UUID id, @RequestBody AppointmentDTO dto) {
        return ResponseEntity.ok(service.updateAppointment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
