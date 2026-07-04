//package com.loginapp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////
////        http
////            .csrf(csrf -> csrf.disable())
////            .authorizeHttpRequests(auth -> auth
////
////                // 🔓 PUBLIC
////                .requestMatchers(
////                    "/login",
////                    "/rooms",
////                    "/rooms/images/**",
////                    "/swagger-ui/**",
////                    "/v3/api-docs/**"
////                ).permitAll()
////
////                // 🔐 PROTECTED
////                .requestMatchers("/rooms/add").authenticated()
////
////                .anyRequest().authenticated()
////            )
////            // 🔥 VERY IMPORTANT
////            .formLogin(form -> form.disable())
////            .httpBasic(Customizer.withDefaults());
////
////        return http.build();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//	
//
//	
//
//	    @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//	        http
//	            .csrf(csrf -> csrf.disable())
//	            .formLogin(form -> form.disable())   // ❌ disable Spring login page
//	            .httpBasic(basic -> basic.disable())// ❌ disable browser popup
//	            .authorizeHttpRequests(auth -> auth
//	                .requestMatchers(
//	                    "/login",
//	                    "/resetPassword",
//	                    "/swagger-ui/**",
//	                    "/v3/api-docs/**",
//	                    "/rooms",
//	                    "/rooms/images/**"
//	                ).permitAll()
//	                .anyRequest().authenticated()
//	            );
//
//	        return http.build();
//	    }
//
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	}
//
