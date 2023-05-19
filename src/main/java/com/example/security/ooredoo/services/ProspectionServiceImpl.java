package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Prospection;
import com.example.security.ooredoo.repositories.ProspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProspectionServiceImpl implements IProspectionService {
    @Autowired
    ProspectionRepository pRepo;

    @Override
    public Prospection retrieveProspectionById(long id) {

        return pRepo.findById(id).get();
    }

    @Override
    public List<Prospection> retrieveAll() {
        return (List<Prospection>) pRepo.findAll();
    }

    @Override
    public Prospection addProspection(Prospection p) {
        p.setDateCreation(LocalDateTime.now());
        p.setDateDernièreModification(LocalDateTime.now());
        return pRepo.save(p);
    }

    @Override
    public Prospection updateProspection(Prospection p, long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteProspection(long id) {
        pRepo.deleteById(id);
    }

    @Override
    public List<Prospection> getAll() {
        return (List<Prospection>) pRepo.findByOrderByIdDesc();
    }

}
