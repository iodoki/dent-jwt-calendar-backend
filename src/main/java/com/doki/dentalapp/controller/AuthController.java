
package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.AuthResponse;
import com.doki.dentalapp.dto.LoginRequest;
import com.doki.dentalapp.dto.RefreshRequest;
import com.doki.dentalapp.dto.UserDTO;
import com.doki.dentalapp.mapper.UserMapper;
import com.doki.dentalapp.model.User;
import com.doki.dentalapp.service.JwtService;
import com.doki.dentalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        System.out.println("✅ Login running..."+ request.username());

        UserDTO userDto = userService.findByUsername(request.username());

        if (!passwordEncoder.matches(request.password(), userDto.password())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String access = jwtService.generateAccessToken(UserMapper.toEntity(userDto));
        String refresh = jwtService.generateRefreshToken(UserMapper.toEntity(userDto));

        return new AuthResponse(access, refresh, userDto);
    }

    @PostMapping("/refresh")
    public AuthResponse refresh(@RequestBody RefreshRequest request) {

        String userId = jwtService.validateRefreshAndGetUserId(request.refreshToken());
        UserDTO userDTO = userService.getById(UUID.fromString(userId));

        String newAccess = jwtService.generateAccessToken(UserMapper.toEntity(userDTO));

        return new AuthResponse(newAccess, request.refreshToken(), userDTO);
    }
}
