package com.example.restfull_jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InitRestTemplate {
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}