
package com.doki.dentalapp.controller;

import com.doki.dentalapp.dto.AuthResponse;
import com.doki.dentalapp.dto.LoginRequest;
import com.doki.dentalapp.dto.RefreshRequest;
import com.doki.dentalapp.dto.UserDTO;
import com.doki.dentalapp.mapper.UserMapper;
import com.doki.dentalapp.model.User;
import com.doki.dentalapp.repository.UserRepository;
import com.doki.dentalapp.service.JwtService;
import com.doki.dentalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        String username = body.get("username");
        String password = body.get("password");
System.out.println("Login..."+ username);
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error","Invalid credentials"));
        }

        String access = jwtService.generateAccessToken(user.get());
        String refresh = jwtService.generateRefreshToken(user.get());

        return ResponseEntity.ok(Map.of(
                "accessToken", access,
                "refreshToken", refresh,
                "user", Map.of(
                        "id", user.get().getId(),
                        "username", user.get().getUsername(),
                        "name", user.get().getFullName(),
                        "email", user.get().getEmail(),
                        "role", user.get().getRole(),
                        "clinicId", user.get().getClinicId()
                )
        ));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String,String> body) {
        String refreshToken = body.get("refreshToken");
        if (refreshToken == null) return ResponseEntity.badRequest().build();
        try {
            var claims = jwtService.getClaims(refreshToken);
            var userId = claims.getSubject();
            User user = userRepo.findById(java.util.UUID.fromString(userId)).orElse(null);
            if (user == null) return ResponseEntity.status(401).build();
            String newAccess = jwtService.generateAccessToken(user);
            return ResponseEntity.ok(Map.of("accessToken", newAccess));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid refresh token"));
        }
    }
}