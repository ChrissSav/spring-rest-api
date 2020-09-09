package com.example.BaseApi.controller;

import com.example.BaseApi.config.ApiException;
import com.example.BaseApi.dto.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @PostMapping
    public void singUp(@Valid @RequestBody RegisterRequest registerRequest) {

        System.out.println(registerRequest.getUsername());
        System.out.println(registerRequest.getEmail());
        System.out.println(registerRequest.getPassword() == null);

        throw new ApiException("rheger8g");
    }
}


