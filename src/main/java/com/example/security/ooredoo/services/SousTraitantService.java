package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Installation;
import com.example.security.ooredoo.entities.SousTraitant;

import java.util.List;
import java.util.Optional;

public interface SousTraitantService {
    public SousTraitant addSousTraitant(SousTraitant sousTraitant);

    public List<SousTraitant> getAllList();
    void deactivate(Integer id);
    void activate(Integer id);

    Optional<SousTraitant> findById(Integer id);

    SousTraitant save(SousTraitant sousTraitant);
    public SousTraitant update (SousTraitant sousTraitant, Integer id);




}
