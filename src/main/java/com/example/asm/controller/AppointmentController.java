package com.example.asm.controller;

import com.example.asm.configuration.CommonResponse;
import com.example.asm.dto.AppointmentDto;
import com.example.asm.dto.ConsultantDto;
import com.example.asm.service.AppointmentService;
import com.example.asm.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> add_consultant(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.add_appointment(appointmentDto);
        return ResponseEntity.ok(new CommonResponse(200, "Saved", null));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_consultant() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", appointmentService.get_all()));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> update_consultant(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.update_appointment(appointmentDto);
        return ResponseEntity.ok(new CommonResponse(200, "Updated", null));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> delete_consultant(@PathVariable(value = "id") long id) {
        appointmentService.delete_appointment(id);
        return ResponseEntity.ok(new CommonResponse(200, "Deleted", null));
    }

    @GetMapping(value = "/consultant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_consultant(@PathVariable(value = "id") long id) {
        return ResponseEntity.ok(new CommonResponse(200, "Success", appointmentService.get_all_appointment_by_consultant(id)));
    }
}
