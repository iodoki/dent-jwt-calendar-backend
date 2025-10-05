
package com.example.dentalapp.controller;

import com.example.dentalapp.model.Role;
import com.example.dentalapp.model.User;
import com.example.dentalapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

   // private final AuthenticationManager authenticationManager;
   // private final JwtService jwtService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String password = request.get("password");
            System.out.println("✅ login running username..."+username);

//            Authentication auth = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );

            User user = userRepository.findByUsername(username).isPresent() ? userRepository.findByUsername(username).get() : null;
            assert user != null;
            List<String> roles = user.getRoles().stream().map(Role::getName).toList();
          //  String token = jwtService.generateToken(user.getUsername(), roles);

            return ResponseEntity.ok(Map.of(
                    "token", "token test ...",
                    "username", username,
                    "roles", roles
            ));

        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid username or password"));
        }
    }
}
