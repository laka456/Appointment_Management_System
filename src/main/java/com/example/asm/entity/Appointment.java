package com.example.asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private String startTime;
    private String endTime;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobSeeker seeker;

    @ManyToOne(fetch = FetchType.LAZY)
    private Consultant consultant;
}
