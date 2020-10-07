package com.example.BaseApi.controller;

import com.example.BaseApi.dto.LoginRequest;
import com.example.BaseApi.dto.RegisterRequest;
import com.example.BaseApi.dto.TokenRequest;
import com.example.BaseApi.dto.UserResponse;
import com.example.BaseApi.service.AuthService;
import javafx.util.Pair;
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

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> singUp(@Valid @RequestBody RegisterRequest registerRequest) {
        Pair<UserResponse, String> user = authService.singUp(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).header("bearer", user.getValue()).body(user.getKey());
    }


    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Pair<UserResponse, String> user = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .header("bearer", user.getValue())
                .body(user.getKey());
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody TokenRequest tokenRequest) {
        authService.deleteSession(tokenRequest.getToken());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully!!");
    }
}


