package com.example.asm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailDto {
    private String to_mail;
    private String msg_body;
    private String subject;
}
