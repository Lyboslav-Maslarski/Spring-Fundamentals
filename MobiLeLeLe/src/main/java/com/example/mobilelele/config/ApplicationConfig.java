package com.example.mobilelele.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new Pbkdf2PasswordEncoder("abc",5,2, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
    }
}
