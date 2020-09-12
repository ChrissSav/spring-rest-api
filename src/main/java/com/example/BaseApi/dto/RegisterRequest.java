package com.example.BaseApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class RegisterRequest {

    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank(message = "user name not null")
    private String password;


}

