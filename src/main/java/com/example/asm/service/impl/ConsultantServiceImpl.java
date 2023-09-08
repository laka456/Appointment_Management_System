package com.example.asm.service.impl;

import com.example.asm.dto.ConsultantDto;
import com.example.asm.dto.EmailDto;
import com.example.asm.dto.UserDto;
import com.example.asm.entity.Consultant;
import com.example.asm.entity.ConsultantAvailability;
import com.example.asm.entity.User;
import com.example.asm.repo.ConsultantAvailabilityRepo;
import com.example.asm.repo.ConsultantRepo;
import com.example.asm.repo.UserRepo;
import com.example.asm.service.ConsultantService;
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
public class ConsultantServiceImpl implements ConsultantService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConsultantRepo consultantRepo;

    @Autowired
    ConsultantAvailabilityRepo consultantAvailabilityRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @Override
    public boolean add_consultant(ConsultantDto consultantDto) {
        Consultant consultant = new Consultant();
        consultant.setCountry(consultantDto.getCountry());
        consultant.setJob_type(consultantDto.getJob_type());
        User user = new User();
        user.setName(consultantDto.getUser().getName());
        user.setRole(consultantDto.getUser().getRole());
        user.setUsername(consultantDto.getUser().getUsername());
        String encode = passwordEncoder.encode(consultantDto.getUser().getPassword());
        user.setPassword(encode);
        consultant.setUser(user);
        consultantRepo.save(consultant);
        EmailDto emailDto = new EmailDto();
        emailDto.setMsg_body("Your Username: " + consultantDto.getUser().getUsername() + "\n" + "Your Password: " + consultantDto.getUser().getPassword());
        emailDto.setTo_mail(consultantDto.getUser().getUsername());
        emailDto.setSubject("User registration");
        emailService.sendEmail(emailDto);
        return true;
    }

    @Override
    public List<ConsultantDto> get_all() {
        List<ConsultantDto> userDtos = new ArrayList<>();
        for (Consultant consultant : consultantRepo.findAll()) {
            ConsultantDto consultantDto = new ConsultantDto();
            consultantDto.setCountry(consultant.getCountry());
            consultantDto.setJob_type(consultant.getJob_type());
            consultantDto.setId(consultant.getId());
            User user = consultant.getUser();
            UserDto userDTO = new UserDto();
            userDTO.setRole(user.getRole());
            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setId(user.getId());
            consultantDto.setUser(userDTO);
            userDtos.add(consultantDto);
        }

        return userDtos;
    }

    @Override
    public boolean update_consultant(ConsultantDto consultantDto) {
        Optional<Consultant> byId = consultantRepo.findById(consultantDto.getId());

        if (byId.isPresent()) {
            Consultant consultant = byId.get();
            consultant.setCountry(consultantDto.getCountry());
            consultant.setJob_type(consultantDto.getJob_type());
            Optional<User> byId1 = userRepo.findById(consultant.getUser().getId());
            User user = byId1.get();
            user.setName(consultantDto.getUser().getName());
            user.setRole(consultantDto.getUser().getRole());
            user.setUsername(consultantDto.getUser().getUsername());
            String encode = passwordEncoder.encode(consultantDto.getUser().getPassword());
            user.setPassword(encode);
            consultant.setUser(user);
            consultantRepo.save(consultant);
        }
        return true;
    }

    @Override
    public boolean delete_consultant(long id) {
        Optional<Consultant> byId = consultantRepo.findById(id);
        Consultant consultant = byId.get();
        if (byId.isPresent()) {
            Optional<ConsultantAvailability> byConsultant = Optional.ofNullable(consultantAvailabilityRepo.findByConsultant(consultant));
            if (byConsultant.isPresent()) {
                ConsultantAvailability consultantAvailability = byConsultant.get();
                consultantAvailabilityRepo.deleteById(consultantAvailability.getId());
            }
            long userId = consultant.getUser().getId();
            consultantRepo.deleteById(consultant.getId());

            Optional<User> byId1 = userRepo.findById(userId);
            if (byId1.isPresent()) {
                User user = byId1.get();
                userRepo.deleteById(userId);
            }
        }
        return true;
    }
}
