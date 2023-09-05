package com.example.asm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatsDto {
    private long totalAppointment;
    private long totalConsultants;
    private long totalSeekers;
    private long totalAvailability;
}
