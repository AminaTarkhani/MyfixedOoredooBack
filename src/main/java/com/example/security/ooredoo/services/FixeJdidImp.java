package com.example.security.ooredoo.services;

import com.example.security.ooredoo.entities.FixeJdid;
import com.example.security.ooredoo.repositories.FixeJdidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FixeJdidImp implements FixeJdidService {
    @Autowired
    private FixeJdidRepo fixeJdidRepo;

    @Override
    public FixeJdid addFixeJdid(FixeJdid fixeJdid) {
        return fixeJdidRepo.save(fixeJdid);
    }

    public FixeJdid add(FixeJdid fixeJdid) {
        return fixeJdidRepo.save(fixeJdid);
    }

@Override
    public FixeJdid findByMsisdn(String msisdn) {
        return fixeJdidRepo.findByMsisdn(msisdn);
    }
    @Override
    public List<FixeJdid> findByMsisdnStartingWith(String prefix) {
        return fixeJdidRepo.findByMsisdnStartsWith(prefix);
    }
    @Override
    public FixeJdid getById(Integer id) {
        return fixeJdidRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FixeJdid not found for id: " + id));
    }

    @Override
    public List<String> getAvailableMsisdns() {
        List<FixeJdid> allFixeJdids = fixeJdidRepo.findAll();
        List<String> availableMsisdns = new ArrayList<>();

        for (FixeJdid fixeJdid : allFixeJdids) {
            if (isMsisdnAvailable(fixeJdid.getMsisdn())) {
                availableMsisdns.add(fixeJdid.getMsisdn());
            }
        }

        return availableMsisdns;
    }

    private boolean isMsisdnAvailable(String msisdn) {
        return msisdn != null && !msisdn.isEmpty();

    }

}
