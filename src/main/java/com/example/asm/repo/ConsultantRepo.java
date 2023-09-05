package com.example.asm.repo;

import com.example.asm.entity.Consultant;
import com.example.asm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepo extends JpaRepository<Consultant, Long> {
}
