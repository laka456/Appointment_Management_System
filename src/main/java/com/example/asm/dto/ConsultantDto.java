package com.example.asm.dto;

import com.example.asm.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultantDto {
    private long id;
    private String job_type;
    private String country;
    private UserDto user;
}
