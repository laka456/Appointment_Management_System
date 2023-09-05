package com.example.asm.controller;

import com.example.asm.configuration.CommonResponse;
import com.example.asm.dto.ConsultantAvailabilityDto;
import com.example.asm.dto.ConsultantDto;
import com.example.asm.service.ConsultantAvailabilityService;
import com.example.asm.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/consultant_availability")
public class ConsultantAvailabilityController {
    @Autowired
    ConsultantAvailabilityService consultantAvailabilityService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> add_consultant(@RequestBody ConsultantAvailabilityDto consultantAvailabilityDto) {
        consultantAvailabilityService.add_availability(consultantAvailabilityDto);
        return ResponseEntity.ok(new CommonResponse(200, "Saved", null));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_consultant() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", consultantAvailabilityService.get_all()));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> update_consultant(@RequestBody ConsultantAvailabilityDto consultantAvailabilityDto) {
        consultantAvailabilityService.update_availability(consultantAvailabilityDto);
        return ResponseEntity.ok(new CommonResponse(200, "Updated", null));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> delete_consultant(@PathVariable(value = "id") long id) {
        consultantAvailabilityService.delete_availability(id);
        return ResponseEntity.ok(new CommonResponse(200, "Deleted", null));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_consultant(@PathVariable(value = "id") long id) {
        return ResponseEntity.ok(new CommonResponse(200, "Success", consultantAvailabilityService.get_all_availability_by_consultant(id)));
    }
}
