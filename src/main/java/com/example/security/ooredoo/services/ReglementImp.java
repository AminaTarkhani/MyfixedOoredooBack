package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.FixeJdid;
import com.example.security.ooredoo.entities.Reglement;
import com.example.security.ooredoo.repositories.FixeJdidRepo;
import com.example.security.ooredoo.repositories.ReglementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReglementImp implements ReglementService {
    @Autowired
     private ReglementRepo reglementRepo;
    @Override
    public Reglement add(Reglement reglement) {
        return reglementRepo.save(reglement);
    }
}

