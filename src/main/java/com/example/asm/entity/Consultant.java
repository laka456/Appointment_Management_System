package com.example.asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String job_type;
    private String country;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "consultant")
    private List<ConsultantAvailability> availability;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seeker")
    private List<Appointment> appointment;
}
