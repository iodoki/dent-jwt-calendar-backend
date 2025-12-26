package com.doki.dentalapp.exeption;

import java.util.UUID;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(UUID id) {
        super("Doctor not found: " + id);
    }
}
