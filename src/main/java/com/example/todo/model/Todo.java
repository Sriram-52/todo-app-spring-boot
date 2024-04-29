package com.example.todo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Component
public class Todo {
    @Id
    private int id;
    private String title;
    private String description;
    private boolean done;
}
