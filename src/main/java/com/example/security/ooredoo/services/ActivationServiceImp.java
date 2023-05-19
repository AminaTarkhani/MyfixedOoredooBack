package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Activation;
import com.example.security.ooredoo.entities.Prospection;
import com.example.security.ooredoo.repositories.ActivationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivationServiceImp implements ActivationService{
    @Autowired
    private ActivationRepo activationRepo;

    @Override
    public Activation add(Activation activation) {

        return activationRepo.save(activation);
    }

    @Override
    public Activation getList(Integer id) {
        return activationRepo.findById(id).get();

    }

    @Override
    public List<Activation> getAllList() {

        return activationRepo.findAll();
    }

    @Override


    public Activation update(Activation a, Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Integer id) {
        activationRepo.deleteById(id);

    }

}
