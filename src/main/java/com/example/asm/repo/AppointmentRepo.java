package com.example.asm.repo;

import com.example.asm.entity.Appointment;
import com.example.asm.entity.Consultant;
import com.example.asm.entity.ConsultantAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> getAllByConsultant(Consultant consultant);
}
