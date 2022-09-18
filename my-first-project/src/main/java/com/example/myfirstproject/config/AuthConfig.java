package com.example.myfirstproject.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class AuthConfig  {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().configurationSource(request -> {
            		var cors = new CorsConfiguration();
            			cors.setAllowedOrigins(List.of("http://localhost:4200", "http://127.0.0.1:80", "http://example.com"));
            			cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            			cors.setAllowedHeaders(List.of("*"));
            			return cors;
        });
        return http.build();
	}
}
