package com.example.jpa_announce.controller;

import com.example.jpa_announce.entity.Announce;
import com.example.jpa_announce.exception.AnnounceNotFoundEx;
import com.example.jpa_announce.service.AnnounceService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/announcements")
public class AnnounceController {
    private static final Logger logger = LoggerFactory.getLogger(AnnounceController.class);

    @Autowired
    private AnnounceService announceService;

    @PostMapping
    public ResponseEntity createAnnounce(@RequestBody Announce announce) {
        logger.debug("Создание объявления: {}", announce);
        announceService.createAnnounce(announce);
        return ResponseEntity.ok("OK!");
    }

    @GetMapping()
    public ResponseEntity getAnnounce(@RequestParam Long id) {
        logger.debug("Получение объявления с id: {}", id);
        return ResponseEntity.ok(announceService.getAnnounce(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartmentId(@PathVariable Long id){
        logger.debug("Удаление объявления с id: {}", id);
        return ResponseEntity.ok(announceService.delete(id));
    }
    //
    /*@GetMapping("/DepId/{DepId}")
    public ResponseEntity getAnnouncesByStudentDepartmentId(@PathVariable Long DepId) {
        try {
            List<Announce> announces = announceService.getAnnouncesByStudent(DepId);
            return ResponseEntity.ok(announces);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }*/
}
