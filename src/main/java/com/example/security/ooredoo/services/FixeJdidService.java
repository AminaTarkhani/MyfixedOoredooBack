package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.FixeJdid;

import java.util.List;

public interface FixeJdidService {
    public FixeJdid addFixeJdid (FixeJdid fixeJdid);
    FixeJdid add(FixeJdid fixeJdid);

    FixeJdid findByMsisdn(String msisdn);

    List<FixeJdid> findByMsisdnStartingWith(String prefix);

    List<String> getAvailableMsisdns();
    FixeJdid getById(Integer id);

}


