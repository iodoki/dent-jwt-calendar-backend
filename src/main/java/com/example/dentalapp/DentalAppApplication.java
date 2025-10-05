
package com.example.dentalapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dentalapp.entity.Role;
import com.example.dentalapp.entity.User;
import com.example.dentalapp.repository.RoleRepository;
import com.example.dentalapp.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class DentalAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DentalAppApplication.class, args);
    }

    // create default roles and admin user at startup if missing
    @Bean
    CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo) {
        return args -> {
            System.out.println("✅ Init running...");
            if (userRepo.findByUsername("admin").isEmpty()) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword("admin123");
                // assign roles
                Set<Role> roles = roleRepo.findByName("ROLE_ADMIN").stream().collect(Collectors.toSet());
                user.setRoles(roles);
                userRepo.save(user);
                System.out.println("Created user admin/admin123");
            }
        };
    }
}