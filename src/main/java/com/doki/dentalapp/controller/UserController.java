package com.doki.dentalapp.controller;

import com.doki.dentalapp.model.Role;
import com.doki.dentalapp.model.User;
import com.doki.dentalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5000")
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Map<String, Object> body) {
        String username = (String) body.get("username");
        String password = (String) body.get("password");
        List<String> roleNames = (List<String>) body.get("roles");

        User user = userService.createUser(username, password, new HashSet<>(roleNames));
        return ResponseEntity.ok(Map.of(
                "id", user.getId(),
                "username", user.getUsername(),
                "roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList())
        ));
    }
}