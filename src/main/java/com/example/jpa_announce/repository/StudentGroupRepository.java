package com.example.jpa_announce.repository;

import com.example.jpa_announce.entity.Announce;
import com.example.jpa_announce.entity.StudentGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentGroupRepository extends CrudRepository<StudentGroup,Long> {
    @Query("SELECT distinct sg FROM StudentGroup sg WHERE sg.groupId = :groupId")
    List<StudentGroup> findByGroupId(@Param("groupId") int groupId);
}
