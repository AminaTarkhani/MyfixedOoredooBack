package com.example.security.ooredoo.services;


import com.example.security.ooredoo.entities.FastBox;
import com.example.security.ooredoo.entities.SuperBox;

import java.util.List;

public interface FastBoxService {

    public FastBox ajouter (FastBox fastBox);
    public FastBox addFastBox (FastBox fastBox);
    public FastBox add (FastBox fastBox);
    public FastBox getList(Integer id);
    public List<FastBox> getAllList();
    public FastBox update (FastBox fastBox,Integer id);
    FastBox getById(Integer id);
    public void delete(Integer id);
    FastBox save(FastBox fastBox);


}
