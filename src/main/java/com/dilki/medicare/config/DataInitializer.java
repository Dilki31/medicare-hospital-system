package com.dilki.medicare.config;

import com.dilki.medicare.entity.*;
import com.dilki.medicare.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (!userRepository.existsByEmail("admin@medicare.com")) {
            User admin = User.builder()
                    .email("admin@medicare.com")
                    .password(passwordEncoder.encode("admin123"))
                    .fullName("System Admin")
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(admin);
        }


        if (!userRepository.existsByEmail("doctor@medicare.com")) {
            User docUser = User.builder()
                    .email("doctor@medicare.com")
                    .password(passwordEncoder.encode("doc123"))
                    .fullName("Dr. Sunil Perera")
                    .role(Role.DOCTOR)
                    .build();
            userRepository.save(docUser);
            Doctor doctor = Doctor.builder()
                    .user(docUser)
                    .specialization("Cardiologist")
                    .consultationFee(new java.math.BigDecimal("2500.00"))
                    .build();
            doctorRepository.save(doctor);
        }


        if (!userRepository.existsByEmail("patient@medicare.com")) {
            User patUser = User.builder()
                    .email("patient@medicare.com")
                    .password(passwordEncoder.encode("pat123"))
                    .fullName("Kamal Silva")
                    .role(Role.PATIENT)
                    .build();
            userRepository.save(patUser);
            Patient patient = Patient.builder()
                    .user(patUser)
                    .phone("0771234567")
                    .build();
            patientRepository.save(patient);
        }

        System.out.println("✅ Test Data Loaded successfully!");
    }
}