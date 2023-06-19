package com.tutorial.todolist.service;

import com.tutorial.todolist.domain.entities.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();
    Todo getById(Long id);
    Todo create(Todo todo);
    Todo update(Long id, Todo updateTodo);
    void delete(Long id);
}
