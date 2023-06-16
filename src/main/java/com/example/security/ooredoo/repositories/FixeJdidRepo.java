package com.example.security.ooredoo.repositories;

import com.example.security.ooredoo.entities.FixeJdid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixeJdidRepo extends JpaRepository<FixeJdid,Integer> {
    FixeJdid findByMsisdn(String msisdn);
    List<FixeJdid> findByMsisdnStartsWith(String prefix);
}
