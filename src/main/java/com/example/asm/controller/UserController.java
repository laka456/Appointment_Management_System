package com.example.asm.controller;

import com.example.asm.configuration.CommonResponse;
import com.example.asm.dto.UserDto;
import com.example.asm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> add_user(@RequestBody UserDto userDTO) {
        userService.add_user(userDTO);
        return ResponseEntity.ok(new CommonResponse(200, "Saved", null));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> get_user() {
        return ResponseEntity.ok(new CommonResponse(200, "Success", userService.get_all()));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> update_user(@RequestBody UserDto userDTO) {
        userService.update_user(userDTO);
        return ResponseEntity.ok(new CommonResponse(200, "Updated", null));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> delete_user(@PathVariable(value = "id") long id) {
        userService.delete_user(id);
        return ResponseEntity.ok(new CommonResponse(200, "Deleted", null));
    }
}
