package com.example.security.ooredoo.repositories;

import com.example.security.ooredoo.entities.FixeJdid;
import com.example.security.ooredoo.entities.FlashBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashBoxRepo extends JpaRepository<FlashBox,Long> {
    FlashBox findByMsisdn(String msisdn);
    List<FlashBox> findByMsisdnStartsWith(String prefix);




}
