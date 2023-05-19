package com.example.security.ooredoo.repositories;

import com.example.security.ooredoo.entities.Prospection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProspectionRepository extends JpaRepository<Prospection, Long> {
    List<Prospection> findByOrderByIdDesc();
}
