package com.example.asm.service;

import com.example.asm.dto.UserDto;

import java.util.List;

public interface UserService {
    boolean add_user(UserDto userDTO);

    List<UserDto> get_all();

    boolean update_user(UserDto userDTO);

    boolean delete_user(long id);
}
