package com.example.asm.entity;

import com.example.asm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String gender;
    private String phone;
    private String country;
    private String job_type;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seeker")
    private List<Appointment> appointment;
}
