package com.example.asm.controller;

import com.example.asm.configuration.CommonResponse;
import com.example.asm.dto.JobSeekerDto;
import com.example.asm.dto.UserDto;
import com.example.asm.service.JobSeekerService;
import com.example.asm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/seeker")
public class JobSeekerController {
    @Autowired
    JobSeekerService seekerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> add_user(@RequestBody JobSeekerDto jobSeekerDto) {
        seekerService.add_seeker(jobSeekerDto);
        return ResponseEntity.ok(new CommonResponse(200, "Saved", null));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_user() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", seekerService.get_all()));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> update_user(@RequestBody JobSeekerDto jobSeekerDto) {
        seekerService.update_seeker(jobSeekerDto);
        return ResponseEntity.ok(new CommonResponse(200, "Updated", null));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> delete_user(@PathVariable(value = "id") long id) {
        seekerService.delete_seeker(id);
        return ResponseEntity.ok(new CommonResponse(200, "Deleted", null));
    }
}
