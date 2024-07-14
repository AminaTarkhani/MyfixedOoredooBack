package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.Activation;
import com.example.security.ooredoo.entities.Installation;
import com.example.security.ooredoo.entities.Intervention;
import com.example.security.ooredoo.entities.SousTraitant;
import com.example.security.ooredoo.services.InstallationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Installation")
@CrossOrigin("*")

public class InstallationController {
    private final InstallationService installationService;

    public InstallationController(InstallationService installationService) {
        this.installationService = installationService;
    }
    @PostMapping("/add")
    public ResponseEntity<Installation> add(@RequestBody Installation userInstallation) {
        Installation installation = new Installation();
        installation.setGouvernorat(userInstallation.getGouvernorat());
        installation.setNom(userInstallation.getNom());
        installation.setPrenom(userInstallation.getPrenom());
        installation.setOffres(userInstallation.getOffres());
        installation.setTel(userInstallation.getTel());
        installation.setLongitude(userInstallation.getLongitude());
        installation.setLatitude(userInstallation.getLatitude());
        installation.setSociete(userInstallation.getSociete());
        installation.setAdresse(userInstallation.getAdresse());
        installation.setDelais(userInstallation.getDelais());
        Installation savedInstallation = installationService.addInstallation(installation);
        return ResponseEntity.ok(savedInstallation);

    }
    @GetMapping("/list")
    public List<Installation> finAllInstallation(){
        return installationService.getAllList();
    }
    @PutMapping("update/{id}")
    @ResponseBody
    Installation update(@RequestBody Installation installation , @PathVariable Integer id ) {
        return  installationService.update(installation,id);
    }
}
