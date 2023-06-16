package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Raccordement;

import java.util.List;

public interface RaccordementService {
    public Raccordement add(Raccordement raccordement);
    public Raccordement getList(Integer id);
    public Raccordement getById(Integer id);
    public List<Raccordement> getAllList();
    public Raccordement update(Raccordement raccordement, Integer id);
    public void delete(Integer id);
    public Raccordement findById(Integer id);
}
