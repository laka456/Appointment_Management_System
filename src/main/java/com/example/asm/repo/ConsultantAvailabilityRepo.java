package com.example.asm.repo;

import com.example.asm.entity.Consultant;
import com.example.asm.entity.ConsultantAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultantAvailabilityRepo extends JpaRepository<ConsultantAvailability, Long> {
    List<ConsultantAvailability> getAllByConsultant(Consultant consultant);

    ConsultantAvailability findByConsultant(Consultant consultant);
}
