package com.example.BaseApi.controller;

import com.example.BaseApi.dto.UserResponse;
import com.example.BaseApi.mapper.UserMapper;
import com.example.BaseApi.model.User;
import com.example.BaseApi.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final AuthService authService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<UserResponse> getDetails() {

        User user = authService.getCurrentUser();
        return new ResponseEntity<>(userMapper.mapToUserResponse(user), HttpStatus.OK);
    }
}
