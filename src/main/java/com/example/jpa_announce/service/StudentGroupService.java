package com.example.jpa_announce.service;

import com.example.jpa_announce.entity.Announce;
import com.example.jpa_announce.entity.StudentGroup;
import com.example.jpa_announce.model.Group;
import com.example.jpa_announce.repository.AnnounceRepository;
import com.example.jpa_announce.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentGroupService {
    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private AnnounceRepository announceRepository;
    public Group createGroup(StudentGroup studentGroup, Long group_id){
        Announce announce = announceRepository.findById(group_id).get();
        studentGroup.setGroup(announce);
        return Group.toModel(studentGroupRepository.save(studentGroup));
    }

    public Group complete(Long id){
        StudentGroup studentGroup = studentGroupRepository.findById(id).get();
        studentGroup.setGroup_name(studentGroup.getGroup_name());
        return Group.toModel(studentGroupRepository.save(studentGroup));}
}
