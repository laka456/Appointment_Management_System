package com.example.asm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ConsultantAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private String startTime;
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Consultant consultant;
}
