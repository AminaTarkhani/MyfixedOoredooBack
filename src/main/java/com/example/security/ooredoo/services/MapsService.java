package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Maps;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public interface MapsService {
    public Maps addMaps(Maps maps);
    public Maps getMaps(Integer id);
    public List<Maps> getAllMaps();
    public Maps update (Maps maps,Integer id);
    public void delete(Integer id);

}
