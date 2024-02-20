package com.example.laba1_.controller;

import com.example.laba1_.service.AnnounceDTO;
import com.example.laba1_.service.ServicesAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController //тут
public class GetAnnounce {

    private final ServicesAPI serviceAPI;

    public GetAnnounce(ServicesAPI serviceAPI) {

        this.serviceAPI = serviceAPI;
    }

    @GetMapping("/announcements/")
    public List<AnnounceDTO> getAnnouncements(@RequestParam int departmentId) {
        return serviceAPI.getAnnouncements(departmentId);
    }
}

