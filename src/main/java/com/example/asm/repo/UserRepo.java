package com.example.asm.repo;

import com.example.asm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User getByUsername(String username);
}
