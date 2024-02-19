package com.example.laba1_.controller;

import com.example.laba1_.service.ServicesAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //тут
public class Controller {

    private final ServicesAPI serviceAPI;

    public Controller(ServicesAPI serviceAPI) {
        this.serviceAPI = serviceAPI;
    }

    @GetMapping("/announcements/")
    public String getAnnouncements(@RequestParam int departmentId) {
        return serviceAPI.getAnnouncements(departmentId);
    }
}

