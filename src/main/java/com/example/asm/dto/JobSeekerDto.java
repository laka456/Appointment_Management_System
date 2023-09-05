package com.example.asm.dto;

import com.example.asm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobSeekerDto {
    private long id;
    private String name;
    private String address;
    private String gender;
    private String phone;
    private String country;
    private String job_type;
    private String email;
}
