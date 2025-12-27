package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.AppointmentNServicesDTO;
import com.doki.dentalapp.dto.PatientAllergyRecordDTO;
import com.doki.dentalapp.dto.PatientDTO;
import com.doki.dentalapp.service.PatientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:5000")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDTO> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO dto) {
        return ResponseEntity.ok(patientService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable UUID id, @RequestBody PatientDTO dto) {
        return ResponseEntity.ok(patientService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PatientDTO>> searchPatients(
            @RequestParam(required = true) String term ,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        System.out.println("🔍 Searching patients with term: '" + term + "'");
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(patientService.search(term, pageable));
    }

    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<AppointmentNServicesDTO>> getPatientHistory(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getPatientAppointmentHistory(id));
    }

    @GetMapping("/{id}/allergies")
    public ResponseEntity<List<PatientAllergyRecordDTO>> getPatientAllergyHistory(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getPatientAllergyHistory(id));
    }

    @PutMapping("/{id}/allergies")
    public ResponseEntity<List<PatientAllergyRecordDTO>> updatePatientAllergyHistory(@PathVariable UUID id, @RequestBody List<PatientAllergyRecordDTO> allergies) {
        patientService.updatePatientAllergyHistory(id, allergies);
        return ResponseEntity.ok(patientService.getPatientAllergyHistory(id));

    }
}
