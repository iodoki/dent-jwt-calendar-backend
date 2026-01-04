package com.doki.dentalapp.exeption;

import java.util.UUID;

public class AllergyQuestionNotFoundException extends RuntimeException {
    public AllergyQuestionNotFoundException(UUID id) {
        super("Allergy question not found: " + id);
    }
}
