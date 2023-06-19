package com.tutorial.todolist.service.impl;

import com.tutorial.todolist.domain.entities.Todo;
import com.tutorial.todolist.repository.TodoRepository;
import com.tutorial.todolist.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAll() {
        List<Todo> todoList = todoRepository.findAll();
        return todoList;
    }

    @Override
    public Todo getById(Long id) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id informado: " + id));
        return todo;
    }

    @Override
    public Todo create(Todo todo) {
        Todo savedTodo = todoRepository.save(todo);
        return savedTodo;
    }

    @Override
    public Todo update(Long id,
                       Todo updateTodo) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id informado: " + id));

        todo.setTodo(updateTodo.getTodo());
        todo.setDeadline(updateTodo.getDeadline());
        todo.setCategory(updateTodo.getCategory());
        todo.setConcluded(updateTodo.isConcluded());
        todo.setActive(updateTodo.isActive());

        Todo updatedTodo = todoRepository.save(todo);

        return updatedTodo;
    }

    @Override
    public void delete(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada com o id informado: " + id);
        }
    }
}
