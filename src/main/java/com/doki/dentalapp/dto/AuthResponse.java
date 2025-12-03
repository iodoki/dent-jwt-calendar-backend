package com.doki.dentalapp.dto;

public record AuthResponse(String accessToken, String refreshToken, UserDTO user) { }
