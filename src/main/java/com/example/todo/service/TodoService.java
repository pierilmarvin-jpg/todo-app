package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class TodoService {

    private final TodoRepository repo;

    // Counters Micrometer
    private final Counter todoCreatedCounter;
    private final Counter todoDeletedCounter;
    private final Counter todoUpdatedCounter;

    public TodoService(TodoRepository repo, MeterRegistry meterRegistry) {
        this.repo = repo;

        // Initialisation des compteurs
        this.todoCreatedCounter = meterRegistry.counter("todo_created_total");
        this.todoDeletedCounter = meterRegistry.counter("todo_deleted_total");
        this.todoUpdatedCounter = meterRegistry.counter("todo_updated_total");
    }

    public List<Todo> getTodos() {
        return repo.findAll();
    }

    public Todo addTodo(Todo todo) {
        todoCreatedCounter.increment(); // ➕
        return repo.save(todo);
    }

    public void deleteTodo(Long id) {
        todoDeletedCounter.increment(); // 🗑️
        repo.delete(id);
    }

    public Todo getTodo(Long id) {
        return repo.findById(id);
    }

    public Todo updateTodo(Long id, Todo todo) {
        todoUpdatedCounter.increment(); // ✏️
        return repo.update(id, todo);
    }
}
