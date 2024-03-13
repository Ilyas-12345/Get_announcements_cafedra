package com.example.jpa_announce.controller;

import com.example.jpa_announce.entity.Announce;
import com.example.jpa_announce.exception.AnnounceNotFoundEx;
import com.example.jpa_announce.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements/")
public class AnnounceController {
    @Autowired
    private AnnounceService announceService;

    @PostMapping
    public ResponseEntity createAnnounce(@RequestBody Announce announce){
        announceService.createAnnounce(announce);
        return ResponseEntity.ok("Объявлено!");
    }

    @GetMapping
    public ResponseEntity getAnnounce(@RequestParam Long id){
        try {
            return ResponseEntity.ok(announceService.getAnnounce(id));
        } catch (AnnounceNotFoundEx e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCafedra_id(@PathVariable Long id){
        try {
            return ResponseEntity.ok(announceService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }    }

    //
    @GetMapping("/useful/cafedra_id/{cafedra_id}")
    public ResponseEntity getAnnouncesByStudentcafedra_id(@PathVariable Long cafedra_id) {
        try {
            List<Announce> announces = announceService.getAnnouncesByStudent(cafedra_id);
            return ResponseEntity.ok(announces);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
