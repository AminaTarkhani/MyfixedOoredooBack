package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.Activation;
import com.example.security.ooredoo.entities.Maps;
import com.example.security.ooredoo.entities.Prospection;
import com.example.security.ooredoo.services.ActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Activation")
@CrossOrigin("*")
public class ActivationController {
    @Autowired
    ActivationService activationService;
    @PostMapping("/add")
    public Activation add (@RequestBody Activation activation){

        return activationService.add(activation);
    }
    @GetMapping("/list")
    public List<Activation> finAllActivation(){

        return activationService.getAllList();
    }
    @PutMapping("update/{id}")
    @ResponseBody
    Activation update(@RequestBody Activation a , @PathVariable Integer id ) {
        return  activationService.update(a,id);
    }
    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable Integer id ){
        activationService.delete(id);
    }


}


