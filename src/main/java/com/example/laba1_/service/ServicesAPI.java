package com.example.laba1_.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // сервис - типо бизнес логика
public class ServicesAPI {
    private final RestTemplate restTemplate;

    public ServicesAPI(RestTemplate restTemplate) {  //Could not autowire. No beans of 'RestTemplate' type found.

        this.restTemplate = restTemplate;
    }

    public String getAnnouncements(int departmentId) {
        String url = "https://iis.bsuir.by/api/v1/announcements/departments?id=" + departmentId;
        return restTemplate.getForObject(url, String.class);
    }
}
