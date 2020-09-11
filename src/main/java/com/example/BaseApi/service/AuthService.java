package com.example.BaseApi.service;


import com.example.BaseApi.dto.RegisterRequest;
import com.example.BaseApi.exceptions.ConflictException;
import com.example.BaseApi.exceptions.ExceptionCodes;
import com.example.BaseApi.model.User;
import com.example.BaseApi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void singUp(RegisterRequest registerRequest) {


        Optional<User> userExist = userRepository.findByEmail(registerRequest.getEmail());
        if (userExist.isPresent())
            throw new ConflictException(ExceptionCodes.EMAIL_ALREADY_EXIST);
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

    }
}
