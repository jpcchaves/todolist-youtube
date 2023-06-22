package com.tutorial.todolist.service;

import com.tutorial.todolist.data.dto.TodoDto;
import com.tutorial.todolist.data.dto.TodoRequestDTO;

import java.util.List;
import java.util.Map;

public interface TodoService {
    Map<String, List<TodoDto>> getAll();

    TodoDto getById(Long id);

    TodoDto create(TodoRequestDTO todoRequestDto);

    TodoDto update(Long id,
                   TodoRequestDTO updateTodo);

    List<TodoDto> findByName(String todo);

    TodoDto concludeTodo(Long id);

    void delete(Long id);
}
