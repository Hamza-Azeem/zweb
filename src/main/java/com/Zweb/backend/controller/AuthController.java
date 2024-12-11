package com.Zweb.backend.controller;

import com.Zweb.backend.dto.UserDto;
import com.Zweb.backend.models.LoginRequest;
import com.Zweb.backend.models.RegistrationRequest;
import com.Zweb.backend.security.CustomizedUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-api")
public class AuthController {
    private final CustomizedUserDetailsService userDetailsService;

    public AuthController(CustomizedUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerNewUser(@RequestBody @Validated RegistrationRequest request){
        return new ResponseEntity<>(userDetailsService.registerUser(request), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated LoginRequest request){
        return new ResponseEntity<>(userDetailsService.loginUser(request), HttpStatus.OK);
    }
}
