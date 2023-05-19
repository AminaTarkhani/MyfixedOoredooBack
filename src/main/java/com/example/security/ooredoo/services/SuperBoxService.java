package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Activation;
import com.example.security.ooredoo.entities.SuperBox;

import java.util.List;

public interface SuperBoxService {
    public SuperBox ajouter (SuperBox superBox);

    public SuperBox addSuperBox (SuperBox superBox);
    public SuperBox getList(Integer id);
    public List<SuperBox> getAllList();
    public SuperBox update (SuperBox superBox,Integer id);
    public void delete(Integer id);
    SuperBox getById(Integer id);
    SuperBox save(SuperBox superBox);
}

