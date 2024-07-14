package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Installation;
import com.example.security.ooredoo.entities.Raccordement;
import com.example.security.ooredoo.entities.SousTraitant;
import com.example.security.ooredoo.repositories.InstallationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallationServiceImp implements InstallationService {
    private final InstallationRepo installationRepo;

    public InstallationServiceImp(InstallationRepo installationRepo) {
        this.installationRepo = installationRepo;
    }

    @Override
    public Installation addInstallation(Installation installation) {
        return installationRepo.save(installation);
    }

    @Override
    public List<Installation> getAllList() {
        return installationRepo.findAll();
    }

    @Override
    public Installation update(Installation newInstallationData, Integer id) {
        Installation existingInstallation = installationRepo.findById(id).orElse(null);
        if (existingInstallation != null) {
            if (newInstallationData.getNom() != null) {
                existingInstallation.setNom(newInstallationData.getNom());
            }
            if (newInstallationData.getPrenom() != null) {
                existingInstallation.setPrenom(newInstallationData.getPrenom());
            }
            if (newInstallationData.getDelais() != null) {
                existingInstallation.setDelais(newInstallationData.getDelais());
            }
            if (newInstallationData.getAdresse() != null) {
                existingInstallation.setAdresse(newInstallationData.getAdresse());
            }
            if (newInstallationData.getLatitude() != null) {
                existingInstallation.setLatitude(newInstallationData.getLatitude());
            }
            if (newInstallationData.getLongitude() != null) {
                existingInstallation.setLongitude(newInstallationData.getLongitude());
            }
            if (newInstallationData.getOffres() != null) {
                existingInstallation.setOffres(newInstallationData.getOffres());
            }
            if (newInstallationData.getGouvernorat() != null) {
                existingInstallation.setGouvernorat(newInstallationData.getGouvernorat());
            }
            if (newInstallationData.getTel() != null) {
                existingInstallation.setTel(newInstallationData.getTel());
            }
            if (newInstallationData.getSociete() != null) {
                existingInstallation.setSociete(newInstallationData.getSociete());
            }


            return installationRepo.save(existingInstallation);
        }
        return null;
    }



}
