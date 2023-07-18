package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.FixeJdid;
import com.example.security.ooredoo.entities.FlashBox;

import java.util.List;

public interface FlashBoxService {
    public FlashBox add (FlashBox flashBox);
    FlashBox findByMsisdn(String msisdn);

    List<FlashBox> findByMsisdnStartingWith(String prefix);


    List<String> getAvailableMsisdns();
}
