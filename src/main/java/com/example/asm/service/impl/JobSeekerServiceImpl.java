package com.example.asm.service.impl;

import com.example.asm.dto.JobSeekerDto;
import com.example.asm.dto.UserDto;
import com.example.asm.entity.JobSeeker;
import com.example.asm.entity.User;
import com.example.asm.repo.JobSeekerRepo;
import com.example.asm.repo.UserRepo;
import com.example.asm.service.JobSeekerService;
import com.example.asm.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JobSeekerRepo jobSeekerRepo;

    @Override
    public boolean add_seeker(JobSeekerDto jobSeekerDto) {
        JobSeeker seeker = new JobSeeker();
        seeker.setName(jobSeekerDto.getName());
        seeker.setGender(jobSeekerDto.getGender());
        seeker.setEmail(jobSeekerDto.getEmail());
        seeker.setCountry(jobSeekerDto.getCountry());
        seeker.setAddress(jobSeekerDto.getAddress());
        seeker.setJob_type(jobSeekerDto.getJob_type());
        seeker.setPhone(jobSeekerDto.getPhone());
        jobSeekerRepo.save(seeker);
        return true;
    }

    @Override
    public List<JobSeekerDto> get_all() {
        return modelMapper.map(jobSeekerRepo.findAll(), new TypeToken<List<JobSeekerDto>>() {
        }.getType());
    }

    @Override
    public boolean update_seeker(JobSeekerDto jobSeekerDto) {
        Optional<JobSeeker> byId = jobSeekerRepo.findById(jobSeekerDto.getId());
        if (byId.isPresent()) {
            JobSeeker seeker = byId.get();
            seeker.setName(jobSeekerDto.getName());
            seeker.setGender(jobSeekerDto.getGender());
            seeker.setEmail(jobSeekerDto.getEmail());
            seeker.setCountry(jobSeekerDto.getCountry());
            seeker.setAddress(jobSeekerDto.getAddress());
            seeker.setJob_type(jobSeekerDto.getJob_type());
            seeker.setPhone(jobSeekerDto.getPhone());
            jobSeekerRepo.save(seeker);
        }
        return true;
    }

    @Override
    public boolean delete_seeker(long id) {
        jobSeekerRepo.deleteById(id);
        return true;
    }
}
