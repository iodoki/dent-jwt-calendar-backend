
package com.example.dentalapp.controller;

import com.example.dentalapp.dto.AuthRequest;
import com.example.dentalapp.entity.Role;
import com.example.dentalapp.entity.User;
import com.example.dentalapp.repository.UserRepository;
import com.example.dentalapp.security.CustomUserDetailsService;
import com.example.dentalapp.security.JwtService;
import com.example.dentalapp.dto.LoginRequest;
import com.example.dentalapp.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String password = request.get("password");
            System.out.println("✅ login running username..."+username);

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            List<String> roles = user.getRoles().stream().map(r -> r.getName()).toList();
            String token = jwtService.generateToken(user.getUsername(), roles);

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "username", username,
                    "roles", roles
            ));

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid username or password"));
        }
    }
}
