package com.example.restfull_jpa.repository;

import com.example.restfull_jpa.entity.AnnounceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceRepository extends JpaRepository<AnnounceDTO,Long> {
}
