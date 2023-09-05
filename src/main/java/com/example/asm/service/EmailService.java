package com.example.asm.service;

import com.example.asm.dto.EmailDto;

public interface EmailService {
    String sendEmail(EmailDto emailDto);

}
