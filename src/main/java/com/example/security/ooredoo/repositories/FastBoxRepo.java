package com.example.security.ooredoo.repositories;

import com.example.security.ooredoo.entities.FastBox;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FastBoxRepo extends JpaRepository<FastBox,Integer> {
    boolean existsByNumeroTT(String numeroTT);



}
