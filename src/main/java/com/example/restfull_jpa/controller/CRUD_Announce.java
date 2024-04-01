package com.example.restfull_jpa.controller;

import com.example.restfull_jpa.entity.AnnounceDTO;
import com.example.restfull_jpa.service.ServiceAnnounce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class CRUD_Announce {
    private final ServiceAnnounce announceService;

    public CRUD_Announce(ServiceAnnounce announceService) {
        this.announceService = announceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnounceDTO> getAnnounceById(@PathVariable Long id) {
        AnnounceDTO announce = announceService.getAnnounceById(id);
        if (announce != null) {
            return new ResponseEntity<>(announce, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<AnnounceDTO> getAllAnnounces() {
        return announceService.getAllAnnounces();
    }

    @PostMapping
    public ResponseEntity<AnnounceDTO> createAnnounce(@RequestBody AnnounceDTO announceDTO) {
        AnnounceDTO createdAnnounce = announceService.createAnnounce(announceDTO);
        return new ResponseEntity<>(createdAnnounce, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnounceDTO> updateAnnounce(@PathVariable Long id, @RequestBody AnnounceDTO announceDTO) {
        AnnounceDTO updatedAnnounce = announceService.updateAnnounce(id, announceDTO);
        if (updatedAnnounce != null) {
            return new ResponseEntity<>(updatedAnnounce, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnounce(@PathVariable Long id) {
        boolean deleted = announceService.deleteAnnounce(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/useful")
    public ResponseEntity<List<AnnounceDTO>> getUsefulAnnouncements(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        List<AnnounceDTO> usefulAnnouncements = announceService.getUsefulAnnouncements(param1, param2);
        if (!usefulAnnouncements.isEmpty()) {
            return new ResponseEntity<>(usefulAnnouncements, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
