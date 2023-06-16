package com.example.security.ooredoo.repositories;

import com.example.security.ooredoo.entities.SMSrequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<SMSrequest, Long> {
}

