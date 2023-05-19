package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Maps;

import java.util.List;


public interface MapsService {
    public Maps addMaps(Maps maps);
    public Maps getMaps(Integer id);
    public List<Maps> getAllMaps();
    public Maps update (Maps maps,Integer id);
    public void delete(Integer id);

}
