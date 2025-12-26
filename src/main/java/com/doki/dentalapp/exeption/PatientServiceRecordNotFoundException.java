package com.doki.dentalapp.exeption;

import java.util.UUID;

public class PatientServiceRecordNotFoundException extends RuntimeException {
    public PatientServiceRecordNotFoundException(UUID id) {
        super("Patient & service record not found: " + id);
    }
}
