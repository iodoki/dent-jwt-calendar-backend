package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.DoctorDTO;
import com.doki.dentalapp.security.MyJwtAuthenticationToken;
import com.doki.dentalapp.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.createDoctor(doctorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable UUID id, @RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable UUID id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable UUID id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
//        String userId = auth.getToken().getSubject();              // same as "sub"
//        String clinicId = auth.getToken().getClaim("clinicId");    // custom claim
//        String role = auth.getToken().getClaim("role");            // custom claim
//
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
}
