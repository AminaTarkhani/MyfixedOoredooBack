package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Installation;
import com.example.security.ooredoo.entities.SousTraitant;
import com.example.security.ooredoo.repositories.SousTraitantRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousTraitantServiceImp implements SousTraitantService {
    private final SousTraitantRepo sousTraitantRepo;

    public SousTraitantServiceImp(SousTraitantRepo sousTraitantRepo) {
        this.sousTraitantRepo = sousTraitantRepo;
    }

    @Override
    public SousTraitant addSousTraitant(SousTraitant sousTraitant) {
        return sousTraitantRepo.save(sousTraitant);
    }
    @Override
    public List<SousTraitant> getAllList() {

        return sousTraitantRepo.findAll();
    }



    @Override
    public void deactivate(Integer id) {
        Optional<SousTraitant> sousTraitantOptional = sousTraitantRepo.findById(id);

        if (sousTraitantOptional.isPresent()) {
            SousTraitant sousTraitant = sousTraitantOptional.get();
            sousTraitant.setDesactive(true); // Marquer l'utilisateur comme désactivé
            sousTraitantRepo.save(sousTraitant);
        } else {
            throw new RuntimeException("Sous-traitant not found with id: " + id);
        }
    }
    @Override
    public void activate(Integer id) {
        Optional<SousTraitant> sousTraitantOptional = sousTraitantRepo.findById(id);

        if (sousTraitantOptional.isPresent()) {
            SousTraitant sousTraitant = sousTraitantOptional.get();
            sousTraitant.setDesactive(false); // Marquer l'utilisateur comme activé
            sousTraitantRepo.save(sousTraitant);
        } else {
            throw new RuntimeException("Sous-traitant not found with id: " + id);
        }
    }


    @Override
    public Optional<SousTraitant> findById(Integer id) {
        return sousTraitantRepo.findById(id);
    }

    @Override
    public SousTraitant save(SousTraitant sousTraitant) {
        return sousTraitantRepo.save(sousTraitant);
    }


    @Override
    public SousTraitant update(SousTraitant newSousTraitantData, Integer id) {
        SousTraitant existingSousTraitant = sousTraitantRepo.findById(id).orElse(null);
        if (existingSousTraitant != null) {
            if (newSousTraitantData.getNomSte() != null) {
                existingSousTraitant.setNomSte(newSousTraitantData.getNomSte());
            }
            if (newSousTraitantData.getMsisdn() != null) {
                existingSousTraitant.setMsisdn(newSousTraitantData.getMsisdn());
            }
            if (newSousTraitantData.getEmailSte() != null) {
                existingSousTraitant.setEmailSte(newSousTraitantData.getEmailSte());
            }
            if (newSousTraitantData.getEmailSte() != null) {
                existingSousTraitant.setEmailSte(newSousTraitantData.getEmailSte());
            }
            if (newSousTraitantData.getNom() != null) {
                existingSousTraitant.setNom(newSousTraitantData.getNom());
            }
            if (newSousTraitantData.getPrenom() != null) {
                existingSousTraitant.setPrenom(newSousTraitantData.getPrenom());
            }
            if (newSousTraitantData.getZone() != null) {
                existingSousTraitant.setZone(newSousTraitantData.getZone());
            }
            if (newSousTraitantData.getCin() != null) {
                existingSousTraitant.setCin(newSousTraitantData.getCin());
            }
            if (newSousTraitantData.getEtat() != null) {
                existingSousTraitant.setEtat(newSousTraitantData.getEtat());
            }
            if (newSousTraitantData.getDate() != null) {
                existingSousTraitant.setDate(newSousTraitantData.getDate());
            }
            if (newSousTraitantData.isDesactive()) {
                existingSousTraitant.setDesactive(newSousTraitantData.isDesactive());
            }
            if (newSousTraitantData.getCommentaire() != null) {
                existingSousTraitant.setCommentaire(newSousTraitantData.getCommentaire());
            }
            return sousTraitantRepo.save(existingSousTraitant);
        }
        return null;
    }

}
