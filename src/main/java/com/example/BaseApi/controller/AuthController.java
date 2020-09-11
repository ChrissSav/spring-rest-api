package com.example.BaseApi.controller;

import com.example.BaseApi.dto.RegisterRequest;
import com.example.BaseApi.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<String> singUp(@Valid @RequestBody RegisterRequest registerRequest) {
        authService.singUp(registerRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.CREATED);
    }
}


