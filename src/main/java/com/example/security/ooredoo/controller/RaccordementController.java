package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.FastBox;
import com.example.security.ooredoo.entities.FixeJdid;
import com.example.security.ooredoo.entities.Raccordement;
import com.example.security.ooredoo.services.RaccordementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("Raccordement")
@CrossOrigin("*")
public class RaccordementController {

    @Autowired
    RaccordementService raccordementService;
    @PostMapping("/add")
    public Raccordement add (@RequestBody Raccordement raccordement){

        return raccordementService.add(raccordement);
    }
    @GetMapping("/list")
    public List<Raccordement> finAllRaccordement(){

        return raccordementService.getAllList();
    }

    @GetMapping("/images/{id}/{columnName}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id, @PathVariable String columnName) {
        Raccordement raccordement = raccordementService.getById(id);

        byte[] imageBytes;
        if (columnName.equals("mondatTT")) {
            imageBytes = raccordement.getMondatTT();

        } else {
            return ResponseEntity.notFound().build();
        }

        // Vérifiez si l'image existe
        if (imageBytes == null) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);


        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }



    @PutMapping("update/{id}")
    @ResponseBody
    Raccordement update(@RequestBody Raccordement rac , @PathVariable Integer id ) {
        return  raccordementService.update(rac,id);
    }
    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable Integer id ){
        raccordementService.delete(id);
    }

}
