package com.example.asm.entity;

import com.example.asm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String password;
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Consultant consultant;
}
