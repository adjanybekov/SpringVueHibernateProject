//package com.example.demo2.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.context.annotation.*;
//import org.springframework.security.config.annotation.authentication.builders.*;
//import org.springframework.security.config.annotation.web.configuration.*;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@EnableWebSecurity
//public class WebSecurityConfig implements WebMvcConfigurer {
//
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder().username("root").password("root").roles("USER").build());
//        return manager;
//    }
//}