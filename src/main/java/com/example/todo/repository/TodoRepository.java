package com.example.todo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.todo.model.Todo;

@Repository
public class TodoRepository {

    private final Map<Long, Todo> todos = new HashMap<>();
    private Long currentId = 1L;

    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    public Todo save(Todo todo) {
        todo.setId(currentId);
        todos.put(currentId, todo);
        currentId++;
        return todo;
    }

    public void delete(Long id) {
        todos.remove(id);
    }

    public Todo findById(Long id) {
        return todos.get(id);
    }

    public Todo update(Long id, Todo todo) {
        todo.setId(id);
        todos.put(id, todo);
        return todo;
    }
}
