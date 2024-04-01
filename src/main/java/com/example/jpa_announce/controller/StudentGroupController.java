package com.example.jpa_announce.controller;

import com.example.jpa_announce.entity.StudentGroup;
import com.example.jpa_announce.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/studentGroup/")
public class StudentGroupController {
    private static final Logger logger = LoggerFactory.getLogger(StudentGroupController.class);

    @Autowired
    public StudentGroupService studentGroupService;

    @PostMapping("/create")
    public ResponseEntity createStudentGroup(@RequestBody StudentGroup studentGroup,
                                             @RequestParam Long group_id){
        logger.debug("Создание студенческой группы: {}", studentGroup);
        return ResponseEntity.ok(studentGroupService.createGroup(studentGroup, group_id));
    }


    @PutMapping("/complete")
    public ResponseEntity createStudentGroup(@RequestParam Long id,
                                             @RequestBody StudentGroup studentGroup){
        logger.debug("Обновление студенческой группы с id: {}", id);
        return ResponseEntity.ok(studentGroupService.complete(id,studentGroup));
    }

    @GetMapping("/studentGroups")
    public List<StudentGroup> getStudentGroupsByGroupId(@RequestParam("groupId") int groupId) {
        logger.debug("Получение студенческих групп по id группы: {}", groupId);
        return studentGroupService.getStudentGroupsByGroupId(groupId);
    }
}
