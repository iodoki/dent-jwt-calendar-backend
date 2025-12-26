package com.doki.dentalapp.exeption;

import java.util.UUID;

public class ClinicServiceNotFoundException extends RuntimeException {
    public ClinicServiceNotFoundException(UUID id) {
        super("Clinic service not found: " + id);
    }}
