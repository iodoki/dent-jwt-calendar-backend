package com.example.dentalapp.controller;

import com.example.dentalapp.dto.ClinicServiceDTO;
import com.example.dentalapp.service.ClinicServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:5173")
public class ClinicServiceController {

    private final ClinicServiceService service;

    public ClinicServiceController(ClinicServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClinicServiceDTO> getAll() {
        return service.getAll();
    }

}