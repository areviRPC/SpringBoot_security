package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// 4. aqui van los filtos 
@Configuration
@EnableWebSecurity
public class SegurityConfig {
    
    // 4.2
    private final String[] PUBLIC_RESOURCES = {"/services/public/get","/auth/**"}; 
    // 4.1
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{ // 4.3
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authRequest -> authRequest
                .requestMatchers(PUBLIC_RESOURCES).permitAll()
                .anyRequest().authenticated()
                ).build();
    }
}
