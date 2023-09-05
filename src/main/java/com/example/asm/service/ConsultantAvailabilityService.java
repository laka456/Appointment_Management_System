package com.example.asm.service;

import com.example.asm.dto.ConsultantAvailabilityDto;
import com.example.asm.dto.ConsultantDto;

import java.util.List;

public interface ConsultantAvailabilityService {
    boolean add_availability(ConsultantAvailabilityDto consultantAvailabilityDto);

    List<ConsultantAvailabilityDto> get_all();

    boolean update_availability(ConsultantAvailabilityDto consultantDto);

    boolean delete_availability(long id);

    List<ConsultantAvailabilityDto> get_all_availability_by_consultant(long id);
}
