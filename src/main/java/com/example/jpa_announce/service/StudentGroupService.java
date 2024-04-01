package com.example.jpa_announce.service;

import org.springframework.beans.factory.annotation.Qualifier;
import com.example.jpa_announce.component.Cach;
import com.example.jpa_announce.entity.Announce;
import com.example.jpa_announce.entity.StudentGroup;
import com.example.jpa_announce.model.Group;
import com.example.jpa_announce.repository.AnnounceRepository;
import com.example.jpa_announce.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupService {
    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    @Qualifier("cach")
    private Cach cache;

    @Autowired
    private AnnounceRepository announceRepository;
    public Group createGroup(StudentGroup studentGroup, Long group_id){
        Announce announce = announceRepository.findById(group_id).get();
        studentGroup.setGroup(announce);
        return Group.toModel(studentGroupRepository.save(studentGroup));
    }

    public Group complete(Long id, StudentGroup studentGroupEntity){
        StudentGroup studentGroup = studentGroupRepository.findById(id).get();
        studentGroup.setGroupId(studentGroupEntity.getGroupId());
        studentGroup.setGroupName(studentGroupEntity.getGroupName());
        return Group.toModel(studentGroupRepository.save(studentGroup));
    }

    public List<StudentGroup> getStudentGroupsByGroupId(int groupId) {
        String cacheKey = "studentGroups_" + groupId;
        if (cache.containsKey(cacheKey)) {
            return (List<StudentGroup>) cache.get(cacheKey);
        } else {
            List<StudentGroup> studentGroups = studentGroupRepository.findByGroupId(groupId);
            cache.put(cacheKey, studentGroups);
            return studentGroups;
        }
    }
}
