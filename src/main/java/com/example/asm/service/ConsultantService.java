package com.example.asm.service;

import com.example.asm.dto.ConsultantDto;
import com.example.asm.dto.UserDto;

import java.util.List;

public interface ConsultantService {
    boolean add_consultant(ConsultantDto consultantDto);

    List<ConsultantDto> get_all();

    boolean update_consultant(ConsultantDto consultantDto);

    boolean delete_consultant(long id);
}
