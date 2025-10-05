package com.doki.dentalapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Request payload for authentication.
 * Note: Keep password as String for common Spring/Jackson interoperability.
 */
public record LoginRequest(
        @NotBlank(message = "Username must not be blank")
        @Size(min = 3, max = 64, message = "Username length must be between 3 and 64 characters")
        String username,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 8, max = 128, message = "Password length must be between 8 and 128 characters")
        String password
) {
    public LoginRequest {
        // Normalize username (common source of subtle login failures). Do not alter password.
        if (username != null) {
            username = username.strip();
        }
    }
}
