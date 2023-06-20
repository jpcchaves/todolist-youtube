package com.tutorial.todolist.service;

import com.tutorial.todolist.data.dto.TodoCreateDto;
import com.tutorial.todolist.data.dto.TodoDto;
import com.tutorial.todolist.domain.entities.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();
    Todo getById(Long id);
    TodoDto create(TodoCreateDto todoCreateDto);
    Todo update(Long id, Todo updateTodo);
    void delete(Long id);
}
