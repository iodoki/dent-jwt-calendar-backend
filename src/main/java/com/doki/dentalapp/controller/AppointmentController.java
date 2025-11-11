
package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.AppointmentDTO;
import com.doki.dentalapp.model.Appointment;
import com.doki.dentalapp.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5000")
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

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable UUID id, @RequestBody AppointmentDTO dto) {
        return ResponseEntity.ok(service.updateAppointment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteAppointment(id);
        System.out.println("🔍 Deleting appointment with id:  '" + id + "'");

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<AppointmentDTO> getAppointments(
            @RequestParam(name = "start_date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,

            @RequestParam(name = "end_date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,

            @RequestParam(name = "view", required = false, defaultValue = "month") String view
    ) {
        return service.findAppointments(startDate, endDate, view);
    }

    @GetMapping("/date/{date}")
    public List<AppointmentDTO> getAppointmentsByDate(
            @PathVariable("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {
        return service.findAppointmentsByDate(date);
    }
}
