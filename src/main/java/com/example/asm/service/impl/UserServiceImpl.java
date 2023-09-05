package com.example.asm.service.impl;

import com.example.asm.dto.EmailDto;
import com.example.asm.dto.UserDto;
import com.example.asm.entity.User;
import com.example.asm.repo.UserRepo;
import com.example.asm.service.EmailService;
import com.example.asm.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @Override
    public boolean add_user(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        user.setUsername(userDTO.getUsername());

        String encode = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encode);
        userRepo.save(user);
        EmailDto emailDto = new EmailDto();
        emailDto.setMsg_body("Your Username: " + userDTO.getUsername() + "\n" + "Your Password: " + userDTO.getPassword());
        emailDto.setTo_mail("yasirulakshitha7890@gmail.com");
        emailDto.setSubject("User registration");
        emailService.sendEmail(emailDto);
        return true;
    }

    @Override
    public List<UserDto> get_all() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            UserDto userDTO = new UserDto();
            userDTO.setRole(user.getRole());
            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setId(user.getId());
            userDtos.add(userDTO);
        }
        return userDtos;
    }

    @Override
    public boolean update_user(UserDto userDTO) {
        Optional<User> byId = userRepo.findById(userDTO.getId());
        if (byId.isPresent()) {
            User user = byId.get();
            user.setName(userDTO.getName());
            user.setRole(userDTO.getRole());
            user.setUsername(userDTO.getUsername());

            String encode = passwordEncoder.encode(userDTO.getPassword());
            user.setPassword(encode);
            userRepo.save(user);
        }
        return true;
    }

    @Override
    public boolean delete_user(long id) {
        userRepo.deleteById(id);
        return true;
    }
}
