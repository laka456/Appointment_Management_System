package com.example.asm.service.impl;

import com.example.asm.dto.*;
import com.example.asm.entity.Appointment;
import com.example.asm.entity.Consultant;
import com.example.asm.entity.ConsultantAvailability;
import com.example.asm.entity.JobSeeker;
import com.example.asm.repo.*;
import com.example.asm.service.AppointmentService;
import com.example.asm.service.ConsultantAvailabilityService;
import com.example.asm.service.EmailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
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
    EmailService emailService;

    @Override
    public boolean add_appointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setDate(appointmentDto.getDate());
        appointment.setStartTime(appointmentDto.getStartTime());
        appointment.setEndTime(appointmentDto.getEndTime());
        Optional<JobSeeker> byId = jobSeekerRepo.findById(appointmentDto.getSeeker().getId());
        JobSeeker seeker = byId.get();
        appointment.setSeeker(seeker);
        Optional<Consultant> byId1 = consultantRepo.findById(appointmentDto.getConsultant().getId());
        Consultant consultant = byId1.get();
        appointment.setConsultant(consultant);
        appointmentRepo.save(appointment);

        EmailDto emailDto = new EmailDto();
        emailDto.setMsg_body("Date: " + appointmentDto.getDate() + "\n" + "Time: " + appointmentDto.getStartTime() + " - " + appointmentDto.getEndTime());
        emailDto.setTo_mail("yasirulakshitha7890@gmail.com");
        emailDto.setSubject("Appointment scheduled");
        emailService.sendEmail(emailDto);
        return true;
    }

    @Override
    public List<AppointmentDto> get_all() {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        for (Appointment appointment : appointmentRepo.findAll()) {
            AppointmentDto appointmentDto = new AppointmentDto();
            appointmentDto.setId(appointment.getId());
            appointmentDto.setDate(appointment.getDate());
            appointmentDto.setStartTime(appointment.getStartTime());
            appointmentDto.setEndTime(appointment.getEndTime());
            Optional<JobSeeker> byId = jobSeekerRepo.findById(appointment.getSeeker().getId());
            JobSeeker seeker = byId.get();
            JobSeekerDto map = modelMapper.map(seeker, JobSeekerDto.class);
            appointmentDto.setSeeker(map);
            Optional<Consultant> byId1 = consultantRepo.findById(appointment.getConsultant().getId());
            Consultant consultant = byId1.get();
            ConsultantDto map1 = modelMapper.map(consultant, ConsultantDto.class);
            UserDto user = map1.getUser();
            user.setPassword(null);
            map1.setUser(user);
            appointmentDto.setConsultant(map1);
            appointmentDtos.add(appointmentDto);
        }
        return appointmentDtos;
    }

    @Override
    public boolean update_appointment(AppointmentDto appointmentDto) {
        Optional<Appointment> byId2 = appointmentRepo.findById(appointmentDto.getId());
        Appointment appointment = byId2.get();
        appointment.setDate(appointmentDto.getDate());
        appointment.setStartTime(appointmentDto.getStartTime());
        appointment.setEndTime(appointmentDto.getEndTime());
        appointmentRepo.save(appointment);
        return true;
    }

    @Override
    public boolean delete_appointment(long id) {
        appointmentRepo.deleteById(id);
        return true;
    }

    @Override
    public List<AppointmentDto> get_all_appointment_by_consultant(long id) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        Consultant consultant = new Consultant();
        consultant.setId(id);
        for (Appointment appointment : appointmentRepo.getAllByConsultant(consultant)) {
            AppointmentDto appointmentDto = new AppointmentDto();
            appointmentDto.setId(appointment.getId());
            appointmentDto.setDate(appointment.getDate());
            appointmentDto.setStartTime(appointment.getStartTime());
            appointmentDto.setEndTime(appointment.getEndTime());
            Optional<JobSeeker> byId = jobSeekerRepo.findById(appointment.getSeeker().getId());
            JobSeeker seeker = byId.get();
            JobSeekerDto map = modelMapper.map(seeker, JobSeekerDto.class);
            appointmentDto.setSeeker(map);
            appointmentDtos.add(appointmentDto);
        }
        return appointmentDtos;
    }
}
