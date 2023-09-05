package com.example.asm.repo;

import com.example.asm.entity.JobSeeker;
import com.example.asm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepo extends JpaRepository<JobSeeker, Long> {
}
