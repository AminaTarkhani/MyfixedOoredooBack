package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.Prospection;

import java.util.List;

public interface IProspectionService {
    public Prospection retrieveProspectionById(long id);
    public List<Prospection> retrieveAll();
    public Prospection addProspection(Prospection p);
    public Prospection updateProspection(Prospection p, long id);
    public void deleteProspection(long id);
    public List<Prospection> getAll();
}
