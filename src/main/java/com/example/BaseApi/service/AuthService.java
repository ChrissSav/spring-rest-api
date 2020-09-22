package com.example.BaseApi.service;


import com.example.BaseApi.dto.LoginRequest;
import com.example.BaseApi.dto.RegisterRequest;
import com.example.BaseApi.dto.UserResponse;
import com.example.BaseApi.exceptions.ConflictException;
import com.example.BaseApi.exceptions.ExceptionCodes;
import com.example.BaseApi.mapper.UserMapper;
import com.example.BaseApi.model.Token;
import com.example.BaseApi.model.User;
import com.example.BaseApi.repository.TokenRepository;
import com.example.BaseApi.repository.UserRepository;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private final TokenRepository tokenRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;

    public Pair<UserResponse, String> singUp(RegisterRequest registerRequest) {
        Optional<User> userExist = userRepository.findByEmail(registerRequest.getEmail());
        if (userExist.isPresent())
            throw new ConflictException(ExceptionCodes.EMAIL_ALREADY_EXIST);
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);
        user = userRepository.save(user);
        return new Pair<>(userMapper.mapToUserResponse(user), generateSession(user));
    }

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }

    public void deleteSession(String session) {
        tokenRepository.deleteBySession(session);
    }

    public String login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = generateSession(getCurrentUser());
        return token;
    }

    public String getSession() {
        return new RandomString(70).nextString();

    }

    public String generateSession(User user) {
        Token token = tokenRepository.save(new Token(getSession(), user));
        return token.getToken();
    }

}














