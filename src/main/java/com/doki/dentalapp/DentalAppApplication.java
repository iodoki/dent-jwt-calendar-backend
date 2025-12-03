
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

    // create default roles and admin user at startup if missing
    @Bean
    CommandLineRunner init(UserRepository userRepo, ClinicRepository clinicRepo) {
        return args -> {
            System.out.println("✅ Init running...");
//
//            System.out.println("✅ By findByTaxIdentity running..." + clinicRepo.findByTaxIdentity("kola_dental_connect_122025").isEmpty());
//            System.out.println("✅ By findByName running..." + clinicRepo.findByName("Doki Dental").isEmpty());
//            System.out.println("✅ By findByTaxIdentity running..." + clinicRepo.findByTaxIdentity("kola_dental_connect_122025").isPresent());
//            System.out.println("✅ By findByName running..." + clinicRepo.findByName("Doki Dental").isPresent());

           if (clinicRepo.findByTaxIdentity("kola_dental_connect_122025").isEmpty()) {
                Clinic clinic = new Clinic();
                clinic.setName("Elda & Edison Kola Dental");
                clinic.setTaxIdentity("kola_dental_connect_122025");
                clinic.setAddress("Lac...");
                clinic.setEmail("kola@dentalconnect.al");
                clinic.setPhone("+35569.....");
                clinicRepo.save(clinic);
            }

            if (userRepo.findByUsername("kola@dentalconnect.al").isEmpty()) {
                User user = new User();
                user.setUsername("kola@dentalconnect.al");
                // assign roles
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                String rawPassword = "Elsoni25!!";
                String hashedPassword = encoder.encode(rawPassword);
                user.setPassword(hashedPassword);
                user.setFullName("Kola Dental");
                user.setEmail("kola@dentalconnect.al");
                user.setRole(Role.ADMIN);
                Optional<Clinic> clinic = clinicRepo.findByTaxIdentity("kola_dental_connect_122025");
                clinic.ifPresent(value -> user.setClinicId(value.getId()));
                userRepo.save(user);
            }

            if (userRepo.findByUsername("elda.kola@dentalconnect.al").isEmpty()) {
                User user = new User();
                user.setUsername("elda.kola@dentalconnect.al");
                // assign roles
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                String rawPassword = "Eldagj.25!!";
                String hashedPassword = encoder.encode(rawPassword);
                user.setPassword(hashedPassword);
                user.setFullName("Dr.Elda Kola");
                user.setEmail("elda.kola@dentalconnect.al");
                user.setRole(Role.DOCTOR);
                Optional<Clinic> clinic = clinicRepo.findByTaxIdentity("kola_dental_connect_122025");
                clinic.ifPresent(value -> user.setClinicId(value.getId()));
                userRepo.save(user);
            }

            if (userRepo.findByUsername("edison.kola@dentalconnect.al").isEmpty()) {
                User user = new User();
                user.setUsername("edison.kola@dentalconnect.al");
                // assign roles
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                String rawPassword = "S@ni.25!!";
                String hashedPassword = encoder.encode(rawPassword);
                user.setPassword(hashedPassword);
                user.setFullName("Dr.Edison Kola");
                user.setEmail("edison.kola@dentalconnect.al");
                user.setRole(Role.DOCTOR);
                Optional<Clinic> clinic = clinicRepo.findByTaxIdentity("kola_dental_connect_122025");
                clinic.ifPresent(value -> user.setClinicId(value.getId()));
                userRepo.save(user);
            }

            if (clinicRepo.findByTaxIdentity("doki_dental_connect_122025").isEmpty()) {
                Clinic clinic = new Clinic();
                clinic.setName("Doki Dental");
                clinic.setTaxIdentity("doki_dental_connect_122025");
                clinic.setAddress("Besnik Sykja, 13, Tirane");
                clinic.setEmail("doki.clinic@dentalconnect.al");
                clinic.setPhone("+355692226446.");
                clinicRepo.save(clinic);
            }

            if (userRepo.findByUsername("mdoklea").isEmpty()) {
                User user = new User();
                user.setUsername("mdoklea");
                // assign roles
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                String rawPassword = "Spirtozi84!!";
                String hashedPassword = encoder.encode(rawPassword);
                user.setPassword(hashedPassword);
                user.setEmail("doklea.meci@gmail.com");
                user.setFullName("Doklea M. Dental");
                user.setRole(Role.SUPER_ADMIN);
                Optional<Clinic> clinic = clinicRepo.findByTaxIdentity("doki_dental_connect_122025");
                clinic.ifPresent(value -> user.setClinicId(value.getId()));
                userRepo.save(user);
            }

            if (userRepo.findByUsername("alice.meta@dentalconnect.al").isEmpty()) {
                User user = new User();
                user.setUsername("alice.meta@dentalconnect.al");
                // assign roles
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                String rawPassword = "m3ta.25!!";
                String hashedPassword = encoder.encode(rawPassword);
                user.setPassword(hashedPassword);
                user.setFullName("Dr.Alice Meta");
                user.setEmail("alice.meta@dentalconnect.al");
                user.setRole(Role.DOCTOR);
                Optional<Clinic> clinic = clinicRepo.findByTaxIdentity("doki_dental_connect_122025");
                clinic.ifPresent(value -> user.setClinicId(value.getId()));
                userRepo.save(user);
            }

            if (userRepo.findByUsername("bruno.mars@dentalconnect.al").isEmpty()) {
                User user = new User();
                user.setUsername("bruno.mars@dentalconnect.al");
                // assign roles
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                String rawPassword = "b3uno.25!!";
                String hashedPassword = encoder.encode(rawPassword);
                user.setPassword(hashedPassword);
                user.setFullName("Bruno Mars");
                user.setEmail("bruno.mars@dentalconnect.al");
                user.setRole(Role.USER);
                Optional<Clinic> clinic = clinicRepo.findByTaxIdentity("doki_dental_connect_122025");
                clinic.ifPresent(value -> user.setClinicId(value.getId()));
                userRepo.save(user);
            }
        };
    }
}