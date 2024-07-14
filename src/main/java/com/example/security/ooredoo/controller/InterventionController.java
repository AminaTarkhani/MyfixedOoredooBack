package com.example.security.ooredoo.controller;
import com.example.security.ooredoo.entities.Intervention;
import com.example.security.ooredoo.entities.SuperBox;
import com.example.security.ooredoo.services.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Intervention")
public class InterventionController {
    private final InterventionService interventionService;

    @Autowired
    public InterventionController(InterventionService interventionService) {
        this.interventionService = interventionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Intervention>  add(@RequestBody Intervention userIntervention) {
        Intervention intervention = new Intervention();
        intervention.setNature(userIntervention.getNature());
        intervention.setId(userIntervention.getId());
        intervention.setAbonnement(userIntervention.getAbonnement());
        intervention.setCategories(userIntervention.getCategories());
        intervention.setDate(userIntervention.getDate());
        intervention.setContact(userIntervention.getContact());
        intervention.setAdresse(userIntervention.getAdresse());
        intervention.setLatitude(userIntervention.getLatitude());
        intervention.setLongitude(userIntervention.getLongitude());
        intervention.setMsisdn(userIntervention.getMsisdn());
        intervention.setNom(userIntervention.getNom());
        intervention.setPlanification(userIntervention.getPlanification());
        intervention.setPrenom(userIntervention.getPrenom());

        Intervention savedIntervention = interventionService.addIntervention(intervention);
        return ResponseEntity.ok(savedIntervention);

    }



    @GetMapping("/list")
    public List<Intervention> finAllIntervention(){

        return interventionService.getAllList();
    }

}
