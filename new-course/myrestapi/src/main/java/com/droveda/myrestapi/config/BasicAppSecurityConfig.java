package com.droveda.myrestapi.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAppSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //* All requests should be authenticated
        //* If a request is not authenticated, a web page is shown with a login form (but we do not want it for rest apis, we want basic auth)
        //* Disabling CSRF -> POST, PUT

        http.authorizeHttpRequests(
                auth -> auth
//                        .requestMatchers("/hello",
//                                "/hello-bean",
//                                "/hello-world/path-variable/**",
//                                "users/**"
//                        ).permitAll() // Public routes
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated() // All other routes are protected
        );

        http.httpBasic(Customizer.withDefaults()); //enabling basic authentication

        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.csrf(AbstractHttpConfigurer::disable); //disabling CSRF

        return http.build();
    }

}
