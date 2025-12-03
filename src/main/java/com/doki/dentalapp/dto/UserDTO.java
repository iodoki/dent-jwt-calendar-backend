package com.doki.dentalapp.dto;

import com.doki.dentalapp.util.Role;

import java.util.UUID;

public record UserDTO(

    UUID id,
    String username,
    String password,
    String fullName,
    UUID clinicId,
    Role role,
    String email
){}

