package com.tutorial.todolist.controller;

import com.tutorial.todolist.data.dto.TodoCreateDto;
import com.tutorial.todolist.data.dto.TodoDto;
import com.tutorial.todolist.domain.entities.Todo;
import com.tutorial.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<TodoDto>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody TodoCreateDto todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id,
                                       @RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.update(id, todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
