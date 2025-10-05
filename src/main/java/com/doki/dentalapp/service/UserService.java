package com.doki.dentalapp.service;

import com.doki.dentalapp.model.User;
import com.doki.dentalapp.model.Role;
import com.doki.dentalapp.repository.RoleRepository;
import com.doki.dentalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User createUser(String username, String rawPassword, Set<String> roleNames) {
        User user = new User();
        user.setUsername(username);
       // user.setPassword(passwordEncoder.encode(rawPassword)); // hash password
         user.setPassword(rawPassword); // hash password

        // assign roles
        Set<Role> roles = roleNames.stream()
                .map(name -> roleRepository.findByName(name)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + name)))
                .collect(Collectors.toSet());

        user.setRoles(roles);

        return userRepository.save(user);
    }
}
