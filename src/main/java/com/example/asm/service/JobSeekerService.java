package com.example.asm.service;

import com.example.asm.dto.JobSeekerDto;
import com.example.asm.dto.UserDto;

import java.util.List;

public interface JobSeekerService {
    boolean add_seeker(JobSeekerDto jobSeekerDto);

    List<JobSeekerDto> get_all();

    boolean update_seeker(JobSeekerDto jobSeekerDto);

    boolean delete_seeker(long id);
}
