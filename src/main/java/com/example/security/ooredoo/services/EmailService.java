package com.example.security.ooredoo.services;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    String sendMail(MultipartFile file, String to, String[] cc, String subject, String body);
}