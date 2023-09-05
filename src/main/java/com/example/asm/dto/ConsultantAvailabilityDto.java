package com.example.asm.dto;

import com.example.asm.entity.Consultant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultantAvailabilityDto {
    private long id;
    private Date date;
    private String startTime;
    private String endTime;
    private ConsultantDto consultant;
}
