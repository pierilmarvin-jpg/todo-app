package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final List<Todo> todos = new ArrayList<>();

    public TodoService() {
        todos.add(new Todo(1L, "Apprendre DevSecOps", false));
        todos.add(new Todo(2L, "Configurer CI/CD", false));
    }

    public List<Todo> getTodos() {
        return todos;
    }
}