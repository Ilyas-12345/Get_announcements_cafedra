package com.example.laba1_.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service // сервис - типо бизнес логика
public class ServicesAPI {
    private final RestTemplate restTemplate;

    public ServicesAPI(RestTemplate restTemplate) {  //Could not autowire. No beans of 'RestTemplate' type found.

        this.restTemplate = restTemplate;
    }

    public List<AnnounceDTO> getAnnouncements(int departmentId) {
        String url = "https://iis.bsuir.by/api/v1/announcements/departments?id=" + departmentId;
        ResponseEntity<AnnounceDTO[]> response = restTemplate.getForEntity(url, AnnounceDTO[].class);
        AnnounceDTO[] announceArray = response.getBody();
        return Arrays.asList(announceArray);
    }
}
