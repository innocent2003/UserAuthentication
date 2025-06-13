package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDefaultUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setName("Admin");
                admin.setUsername("admin");
                admin.setEmail("admin@example.com");
                admin.setPhone("0123456789");
                admin.setPassword(passwordEncoder.encode("admin123")); // Mã hóa mật khẩu
//                admin.setRole("ADMIN");
                admin.setStatus("ACTIVE");

                userRepository.save(admin);
                System.out.println("✅ Default admin user created: username=admin, password=admin123");
            }
        };
    }
}

