package com.example.jpa_announce.repository;

import com.example.jpa_announce.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;

public interface StudentGroupRepository extends CrudRepository<StudentGroup,Long> {
}
