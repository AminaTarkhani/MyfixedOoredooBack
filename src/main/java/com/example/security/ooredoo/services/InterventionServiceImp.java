package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.*;
import com.example.security.ooredoo.repositories.InterventionRepo;
import com.example.security.ooredoo.repositories.SousTraitantRepo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InterventionServiceImp implements InterventionService {
    private final InterventionRepo interventionRepo;
    private final SousTraitantRepo sousTraitantRepo;

    public InterventionServiceImp(InterventionRepo interventionRepo, SousTraitantRepo sousTraitantRepo) {
        this.interventionRepo = interventionRepo;
        this.sousTraitantRepo=sousTraitantRepo;   }

    @Override
    public String getPlanificationForIntervention(Integer interventionId, Integer sousTraitantId) {

        throw new UnsupportedOperationException("Méthode getPlanificationForIntervention non implémentée");
    }

    @Override
    public Intervention addIntervention(Intervention intervention) {


        return interventionRepo.save(intervention);
    }

    private boolean estAutorise(SousTraitant sousTraitant, Intervention intervention) {

        return true;
    }
    public List<Intervention> getAllList() {
        return interventionRepo.findAll();
    }
    @Override
    public boolean isWithin48Hours(Date date) {
        Date currentDate = new Date();
        long diffInMilliseconds = date.getTime() - currentDate.getTime();
        long diffInHours = diffInMilliseconds / (60 * 60 * 1000);

        return diffInHours <= 48;
    }
    public Intervention update(Intervention i, Integer id) {
        return null;
    }


}









