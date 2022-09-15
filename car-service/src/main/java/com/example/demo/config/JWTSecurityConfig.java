package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = false, securedEnabled = false, jsr250Enabled = true)
public class JWTSecurityConfig{
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .authorizeRequests(authz -> authz
              .antMatchers(HttpMethod.GET, "/api/**").hasAnyAuthority("SCOPE_read")
              .antMatchers(HttpMethod.POST, "/api/**").hasAnyAuthority("SCOPE_write")
             .anyRequest().authenticated())
          .oauth2ResourceServer(oauth2 -> oauth2.jwt());
        
        return http.build();
	}
}
