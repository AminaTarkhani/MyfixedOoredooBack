package com.example.security.ooredoo.controller;
import com.example.security.ooredoo.entities.Installation;
import com.example.security.ooredoo.entities.SousTraitant;
import com.example.security.ooredoo.services.SousTraitantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SousTraitant")
@CrossOrigin(origins = "http://localhost:4200")
public class SousTraitantController {
    private final SousTraitantService sousTraitantService;

    public SousTraitantController(SousTraitantService sousTraitantService) {
        this.sousTraitantService = sousTraitantService;
    }

    @PostMapping("/add")
    public SousTraitant add(@RequestBody SousTraitant sousTraitant) {
        return sousTraitantService.addSousTraitant(sousTraitant);
    }
    @GetMapping("/list")
    public List<SousTraitant> finAllIntervention(){
        return sousTraitantService.getAllList();
    }


    @PatchMapping("desactivate/{id}")
    @ResponseBody
    void desactivate(@PathVariable("id") Integer id) {
        sousTraitantService.deactivate(id);
    }
    @PatchMapping("/activate/{id}")
    public ResponseEntity<Void> activateSousTraitant(@PathVariable("id") Integer id) {
        sousTraitantService.activate(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("update/{id}")
    @ResponseBody
    SousTraitant update(@RequestBody SousTraitant sousTraitant , @PathVariable Integer id ) {
        return  sousTraitantService.update(sousTraitant,id);
    }



}

