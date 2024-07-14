package com.example.security.ooredoo.repositories;

import com.example.security.ooredoo.entities.Installation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallationRepo extends JpaRepository<Installation,Integer> {
}
