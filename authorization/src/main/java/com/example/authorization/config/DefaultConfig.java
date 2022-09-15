package com.example.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.authorization.service.CustomUserDetailService;


@EnableWebSecurity
public class DefaultConfig {
	@Autowired 
    CustomUserDetailService _service;
	@Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(_service).passwordEncoder(passwordEncoder());
    }
	
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
    SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception {
        
        http
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
        .formLogin(Customizer.withDefaults());
        
        return http.build();
    }
	
	@Bean
    public UserDetailsService users() {
        return _service;
    }
}
