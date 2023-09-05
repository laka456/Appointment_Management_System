package com.example.asm.dto;

import com.example.asm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDto {
    private long id;
    private Date date;
    private String startTime;
    private String endTime;
    private String type;
    private JobSeekerDto seeker;
    private ConsultantDto consultant;
}
