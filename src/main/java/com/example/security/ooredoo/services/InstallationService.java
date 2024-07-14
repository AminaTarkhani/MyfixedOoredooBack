package com.example.security.ooredoo.services;


import com.example.security.ooredoo.entities.Installation;

import java.util.List;

public interface InstallationService {
    public Installation addInstallation (Installation installation);
    public List<Installation> getAllList();
    public Installation update (Installation installation, Integer id);



}
