package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.Prospection;
import com.example.security.ooredoo.services.IProspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("Prospection")
@CrossOrigin(origins = "http://localhost:8100")
public class ProspectionController {
    @Autowired
    private IProspectionService pService;

    @PostMapping("/addProspection")
    @ResponseBody
    Prospection addProspection(@RequestBody Prospection p) {
        return pService.addProspection(p);
    }

    @GetMapping("/getallprospections")
    @ResponseBody
    public List<Prospection> getAll() {
        List<Prospection> listProspections = pService.getAll();
        return listProspections;
    }

    @GetMapping("/retrieveallprospections")
    @ResponseBody
    public List<Prospection> retrieveAll() {
        List<Prospection> listProspections = pService.retrieveAll();
        return listProspections;
    }


    @GetMapping("retrieveProspection/{id}")
    @ResponseBody
    Prospection retrieveProspectionById(@PathVariable long id ) {
        return pService.retrieveProspectionById(id);
    }

    @DeleteMapping("deleteProspection/{id}")
    @ResponseBody
    void deleteProspection(@PathVariable("id") long id) {
        pService.deleteProspection(id);
    }



    @PutMapping("modifyProspection/{id}")
    @ResponseBody
    Prospection updateProspection(@RequestBody Prospection p , @PathVariable long id ) {
        return  pService.updateProspection(p,id);
    }
}
