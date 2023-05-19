package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Activation;

import java.util.List;

public interface ActivationService {
    public Activation add (Activation activation);
    public Activation getList(Integer id);
    public List<Activation> getAllList();
    public Activation update (Activation activation,Integer id);
    public void delete(Integer id);
}
