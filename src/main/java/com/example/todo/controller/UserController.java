package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.AuthUser;
import com.example.todo.repo.UserRepository;
import com.example.todo.service.JwtService;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public AuthUser create(@RequestBody AuthUser user) {
        System.out.println("Creating user" + user);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }

    @PostMapping("login")
    public String login(@RequestBody AuthUser user) throws Exception {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (auth.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        }
        throw new Exception("Invalid credentials");
    }
    
}
