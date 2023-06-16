package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.services.EmailService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/email")
public class EmailSenderController {
    private EmailService emailService;
    public EmailSenderController(EmailService emailService){
        this.emailService=emailService;
    }
    @PostMapping("/send")
    public String sendEmail(@RequestParam(value = "file", required = false) MultipartFile file,
                            @RequestParam("to") String to,
                            @RequestParam("cc") String[] cc,
                            @RequestParam("subject") String subject,
                            @RequestParam("body") String body) {
        return emailService.sendMail(file, to, cc, subject, body);
    }


}
