package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.AuthUser;
import com.example.todo.repo.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("register")
    public AuthUser create(@RequestBody AuthUser user) {
        System.out.println("Creating user" + user);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }
}
