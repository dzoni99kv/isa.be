package com.example.TaskApp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:4200") // Allow requests from your Angular app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed methods
                .allowedHeaders("*"); // Allow all headers
    }
}