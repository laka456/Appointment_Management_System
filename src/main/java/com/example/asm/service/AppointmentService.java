package com.example.asm.service;

import com.example.asm.dto.AppointmentDto;
import com.example.asm.dto.ConsultantAvailabilityDto;

import java.util.List;

public interface AppointmentService {
    boolean add_appointment(AppointmentDto appointmentDto);

    List<AppointmentDto> get_all();

    boolean update_appointment(AppointmentDto appointmentDto);

    boolean delete_appointment(long id);

    List<AppointmentDto> get_all_appointment_by_consultant(long id);
}
