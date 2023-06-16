package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.SMSrequest;
import com.example.security.ooredoo.services.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ooredoo")
@Slf4j
public class SmsController {
    @Autowired
    private SmsService smsService;
    @PostMapping("/SMS")

    public String processSMS(@RequestBody SMSrequest smsrequest) {
        log.info("processSMS started sendRequest: " + smsrequest.toString());
        return smsService.sendSMS(smsrequest.getSmsMessages(), smsrequest.getDestinationSMSNumber());
    }

}
