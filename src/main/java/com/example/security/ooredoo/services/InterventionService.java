package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Activation;
import com.example.security.ooredoo.entities.FlashBox;
import com.example.security.ooredoo.entities.Intervention;
import com.example.security.ooredoo.entities.SuperBox;

import java.util.Date;
import java.util.List;

public interface InterventionService {
    String getPlanificationForIntervention(Integer interventionId, Integer sousTraitantId);
    public Intervention addIntervention (Intervention intervention);
    public List<Intervention> getAllList();
    boolean isWithin48Hours(Date date);
    public Intervention update (Intervention intervention, Integer id);





}
