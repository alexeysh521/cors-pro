package com.example.cors_test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
//    @Value("${spring.web.cors.allowed-origins}")
//    private String[] allowedOrigins;
//
//    @Value("${spring.web.cors.allowed-methods}")
//    private String[] allowedMethods;
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins(allowedOrigins)
//                .allowedMethods(allowedMethods)
//                .allowedHeaders("*")
//                .allowCredentials(false)
//                .maxAge(3600);
//    }
}
