package com.example.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Todo;
import com.example.todo.repo.TodoRepository;

@RestController
public class TodoRestController {
    @Autowired
    private TodoRepository repository;

    @PostMapping("todo")
    public Todo create(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @GetMapping("todo")
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @GetMapping("todo/{id}")
    public Optional<Todo> getOne(@PathVariable("id") int id) {
        return repository.findById(id);
    }

    @PutMapping("todo/{id}")
    public Todo update(@RequestBody Todo todo, @PathVariable("id") int id) {
        todo.setId(id);
        return repository.save(todo);
    }

    @DeleteMapping("todo/{id}")
    public String delete(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "Todo deleted successfully";
    }
}
