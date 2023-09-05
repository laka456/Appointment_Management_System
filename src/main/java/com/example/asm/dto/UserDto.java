package com.example.asm.dto;

import com.example.asm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private long id;
    private String name;
    private String username;
    private String password;
    private Role role;
}
