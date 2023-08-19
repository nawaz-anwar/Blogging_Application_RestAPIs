package com.retsapis.blogging_application.controllers;

import com.retsapis.blogging_application.payloads.UserDto;
import com.retsapis.blogging_application.servies.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDTO = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public String handle(){
        return "Testing";
    }
}
