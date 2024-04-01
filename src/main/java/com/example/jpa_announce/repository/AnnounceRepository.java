package com.example.jpa_announce.repository;

import com.example.jpa_announce.entity.Announce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnounceRepository extends CrudRepository<Announce,Long> {
    /*@Query("SELECT DISTINCT a FROM Announce a WHERE a.departmentId =:departmentId")
    List<Announce> findByStudentDepartmentId(@Param("departmentId") Long departmentId);*/
}
