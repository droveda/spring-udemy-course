package com.droveda.myrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //* All requests should be authenticated
        //* If a request is not authenticated, a web page is shown with a login form (but we do not want it for rest apis, we want basic auth)
        // * CSRF -> POST, PUT

        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/hello", "/hello-bean").permitAll() // Public routes
                        .anyRequest().authenticated() // All other routes are protected
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
