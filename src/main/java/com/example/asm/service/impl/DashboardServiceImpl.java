package com.example.asm.service.impl;

import com.example.asm.dto.*;
import com.example.asm.entity.Appointment;
import com.example.asm.entity.Consultant;
import com.example.asm.entity.JobSeeker;
import com.example.asm.repo.*;
import com.example.asm.service.AppointmentService;
import com.example.asm.service.DashboardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConsultantRepo consultantRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    JobSeekerRepo jobSeekerRepo;

    @Autowired
    AppointmentRepo appointmentRepo;

    @Autowired
    ConsultantAvailabilityRepo consultantAvailabilityRepo;

    @Override
    public StatsDto get_stats() {
        long count = appointmentRepo.count();
        StatsDto statsDto = new StatsDto();
        statsDto.setTotalAppointment(count);
        long count1 = consultantRepo.count();
        statsDto.setTotalConsultants(count1);
        long count2 = jobSeekerRepo.count();
        statsDto.setTotalSeekers(count2);
        long count3 = consultantAvailabilityRepo.count();
        statsDto.setTotalAvailability(count3);
        return statsDto;
    }
}
