package com.example.security.ooredoo.controller;
import com.example.security.ooredoo.entities.FastBox;
import com.example.security.ooredoo.entities.FlashBox;
import com.example.security.ooredoo.services.FlashBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("FlashBox")
@CrossOrigin("*")
public class FlashBoxController {
    @Autowired
    FlashBoxService flashBoxService;

    @PostMapping("/add")
    public FlashBox add(@RequestBody FlashBox flashBox) {
        if ("Level 4".equals(flashBox.getIsChecked())) {
            flashBox.setIsChecked(null);
        } else {
            flashBox.setIsChecked("Level 4");
        }

        return flashBoxService.add(flashBox);
    }


    @GetMapping("/search")
    public List<FlashBox> search(@RequestParam("msisdn") String msisdn) {
        if (msisdn.isEmpty()) {

            return Collections.emptyList();         }

        String prefix = msisdn.substring(0, 1);

        List<FlashBox> resultList = flashBoxService.findByMsisdnStartingWith(prefix);

        return resultList;
    }
    @GetMapping("/getAvailableMsisdns")
    public List<String> getAvailableMsisdns() {
        List<String> availableMsisdns = flashBoxService.getAvailableMsisdns();
        return availableMsisdns;
    }
    @GetMapping("/list")
    public List<FlashBox> finAllFlashBox(){

        return flashBoxService.getAllList();
    }

}




