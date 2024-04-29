package com.example.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.model.AuthUser;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Integer> {
    public AuthUser findByUserName(String userName);
}
