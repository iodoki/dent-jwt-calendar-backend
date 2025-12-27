package com.doki.dentalapp.exeption;

import java.util.UUID;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(UUID id) {
        super("Patient not found: " + id);
    }
}
