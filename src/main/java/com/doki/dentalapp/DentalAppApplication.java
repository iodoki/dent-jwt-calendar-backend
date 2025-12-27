
package com.doki.dentalapp;

import com.doki.dentalapp.model.Clinic;
import com.doki.dentalapp.repository.ClinicRepository;
import com.doki.dentalapp.repository.UserRepository;
import com.doki.dentalapp.util.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.doki.dentalapp.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class DentalAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DentalAppApplication.class, args);
    }
}