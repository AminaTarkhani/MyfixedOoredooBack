package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.Maps;
import com.example.security.ooredoo.services.MapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Maps")
@CrossOrigin("*")

public class MapsController {

    @Autowired
    MapsService mapsService;
    @PostMapping("/add")
    public Maps add (@RequestBody Maps maps){

        return mapsService.addMaps(maps);
    }
    @GetMapping("/maps")
    public List<Maps> findAllMaps(){

        return mapsService.getAllMaps();
    }

    @GetMapping("{id}")
    public Maps getOne(@PathVariable Integer id)
    {
        return mapsService.getMaps(id);
    }

    @PutMapping("/update/{id}")
    public Maps update(@PathVariable Integer id, @RequestBody Maps maps) {
        Maps existingMaps = mapsService.getMaps(id);
        existingMaps.setLatitude(maps.getLatitude());
        existingMaps.setLongitude(maps.getLongitude());
        existingMaps.setEtat(maps.getEtat());
        existingMaps.setDate_creation(maps.getDate_creation());
        existingMaps.setAdresse(maps.getAdresse());
        return mapsService.addMaps(existingMaps);
    }
    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Integer id ){
         mapsService.delete(id);
}
}
