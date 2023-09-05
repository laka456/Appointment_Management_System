package com.example.asm.controller;

import com.example.asm.configuration.CommonResponse;
import com.example.asm.dto.AppointmentDto;
import com.example.asm.service.AppointmentService;
import com.example.asm.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_consultant() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", dashboardService.get_stats()));
    }
}
