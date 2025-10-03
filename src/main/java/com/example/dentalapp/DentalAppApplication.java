
package com.example.dentalapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dentalapp.entity.Role;
import com.example.dentalapp.entity.User;
import com.example.dentalapp.repository.RoleRepository;
import com.example.dentalapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DentalAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DentalAppApplication.class, args);
    }

    // create default roles and admin user at startup if missing
    @Bean
    CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            Role adminRole = roleRepo.findByName("ROLE_ADMIN").orElseGet(() -> roleRepo.save(new Role(null, "ROLE_ADMIN")));
            Role userRole = roleRepo.findByName("ROLE_USER").orElseGet(() -> roleRepo.save(new Role(null, "ROLE_USER")));

            if (userRepo.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setFullName("Administrator");
                admin.setPassword(passwordEncoder.encode("password"));
                admin.getRoles().add(adminRole);
                userRepo.save(admin);
                System.out.println("Created default admin user -> username: admin password: password");
            }
        };
    }
}
