package com.example.userservice.configs;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
//commented out as it is not used in the current implementation for oauth2 authorization server
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorizeRequests -> {
//            try {
//                authorizeRequests.anyRequest().permitAll();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//
//            }
//
//        });
//        return http.build();
//    }
}
