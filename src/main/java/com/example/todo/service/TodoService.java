package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> getTodos() {
        return repo.findAll();
    }

    public Todo addTodo(Todo todo) {
        return repo.save(todo);
    }

    public void deleteTodo(Long id) {
        repo.delete(id);
    }

    public Todo getTodo(Long id) {
        return repo.findById(id);
    }

    public Todo updateTodo(Long id, Todo todo) {
        return repo.update(id, todo);
    }
}
