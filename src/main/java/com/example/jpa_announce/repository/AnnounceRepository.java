package com.example.jpa_announce.repository;

import com.example.jpa_announce.entity.Announce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnounceRepository extends CrudRepository<Announce,Long> {
    @Query("SELECT a FROM Announce a WHERE a.cafedra_id =:cafedra_id")
    List<Announce> findByStudentcafedra_id(@Param("cafedra_id") Long cafedra_id);
}
