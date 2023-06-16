package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.Reglement;
import com.example.security.ooredoo.services.ReglementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("Reglement")
public class ReglementController {
    @Autowired
    private ReglementService reglementService;
    @PostMapping("/add")
    Reglement add (@RequestBody Reglement reglement) {
        return reglementService.add(reglement);
    }

}
