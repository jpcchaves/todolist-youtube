package com.tutorial.todolist.service.impl;

import com.tutorial.todolist.data.dto.TodoCreateDto;
import com.tutorial.todolist.data.dto.TodoDto;
import com.tutorial.todolist.domain.entities.Category;
import com.tutorial.todolist.domain.entities.Todo;
import com.tutorial.todolist.repository.CategoryRepository;
import com.tutorial.todolist.repository.TodoRepository;
import com.tutorial.todolist.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;

    public TodoServiceImpl(TodoRepository todoRepository,
                           CategoryRepository categoryRepository) {
        this.todoRepository = todoRepository;
        this.categoryRepository = categoryRepository;
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
    public TodoDto create(TodoCreateDto todoCreateDto) {
        Category category = categoryRepository
                .findById(todoCreateDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o id informado: " + todoCreateDto.getCategoryId()));

        Todo todo = new Todo();

        todo.setTodo(todoCreateDto.getTodo());
        todo.setDeadline(todoCreateDto.getDeadline());
        todo.setActive(todoCreateDto.isActive());
        todo.setConcluded(todoCreateDto.isConcluded());
        todo.setCategory(category);


        Todo savedTodo = todoRepository.save(todo);
        TodoDto todoDto = new TodoDto();

        BeanUtils.copyProperties(savedTodo,todoDto);

        return todoDto;
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
