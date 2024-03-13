package com.example.jpa_announce.controller;

import com.example.jpa_announce.entity.StudentGroup;
import com.example.jpa_announce.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentGroup/")
public class StudentGroupController {
    @Autowired
    public StudentGroupService studentGroupService;
    @PostMapping("/create")
    public ResponseEntity createStudentGroup(@RequestBody StudentGroup studentGroup,
                                             @RequestParam Long group_id){
        try{
            return ResponseEntity.ok(studentGroupService.createGroup(studentGroup, group_id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PutMapping("/complete")
    public ResponseEntity createStudentGroup(@RequestParam Long id){
        try{
            return ResponseEntity.ok(studentGroupService.complete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
