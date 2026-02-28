package com.apnaadmi.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // ✅ PUBLIC PAGES
                        .requestMatchers(
                                "/",
                                "/login",
                                "/register",
                                "/services",
                                "/services/**",
                                "/contact",
                                "/api/chat",
                                "/css/**",
                                "/js/**",
                                "/img/**"
                        ).permitAll()

                        // 🔒 ADMIN
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // 👤 USER
                        .requestMatchers("/user/**").hasRole("USER")

                        // 🔐 EVERYTHING ELSE
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/post-login", true)
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
