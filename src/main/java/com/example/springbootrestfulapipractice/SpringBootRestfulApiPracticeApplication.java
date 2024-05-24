package com.example.springbootrestfulapipractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootRestfulApiPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestfulApiPracticeApplication.class, args);
    }

//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/student").allowedOrigins("http://localhost:4200");
//            }
//        };
//    }
}
