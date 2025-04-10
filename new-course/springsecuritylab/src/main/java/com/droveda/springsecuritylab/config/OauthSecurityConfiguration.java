package com.droveda.springsecuritylab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class OauthSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth
//                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .anyRequest().authenticated();

        });

        http.oauth2Login(Customizer.withDefaults());

        return http.build();
    }

}
