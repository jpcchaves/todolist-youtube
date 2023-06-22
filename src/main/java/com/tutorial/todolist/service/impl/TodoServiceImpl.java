package com.tutorial.todolist.service.impl;

import com.tutorial.todolist.data.dto.CategoryDto;
import com.tutorial.todolist.data.dto.TodoDto;
import com.tutorial.todolist.data.dto.TodoRequestDTO;
import com.tutorial.todolist.domain.entities.Category;
import com.tutorial.todolist.domain.entities.Todo;
import com.tutorial.todolist.exception.ResourceNotFoundException;
import com.tutorial.todolist.repository.CategoryRepository;
import com.tutorial.todolist.repository.TodoRepository;
import com.tutorial.todolist.service.TodoService;
import com.tutorial.todolist.utils.mapper.MapperUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;
    private final MapperUtils mapperUtils;

    public TodoServiceImpl(TodoRepository todoRepository,
                           CategoryRepository categoryRepository,
                           MapperUtils mapperUtils) {
        this.todoRepository = todoRepository;
        this.categoryRepository = categoryRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Map<String, List<TodoDto>> getAll() {
        List<Category> categoryList = categoryRepository.findAll();

        List<CategoryDto> categoryDtoList = mapperUtils.parseListObjects(categoryList, CategoryDto.class);

        Map<String, List<TodoDto>> todoDtoMap = new HashMap<>();
        for (CategoryDto dto : categoryDtoList) {
            todoDtoMap.put(dto.getName(), dto.getTodos());
        }

        return todoDtoMap;
    }

    @Override
    public TodoDto getById(Long id) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o id informado: " + id));
        return mapperUtils.parseObject(todo, TodoDto.class);
    }

    @Override
    public TodoDto create(TodoRequestDTO todoRequestDto) {
        Category category = categoryRepository
                .findById(todoRequestDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o id informado: " + todoRequestDto.getCategoryId()));

        Todo todo = new Todo();

        todo.setTodo(todoRequestDto.getTodo());
        todo.setDeadline(todoRequestDto.getDeadline());
        todo.setConcluded(false);
        todo.setCategory(category);


        Todo savedTodo = todoRepository.save(todo);

        return mapperUtils.parseObject(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto update(Long id,
                          TodoRequestDTO updateTodo) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o id informado: " + id));

        Category category = categoryRepository
                .findById(updateTodo.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o id informado: " + updateTodo.getCategoryId()));

        todo.setTodo(updateTodo.getTodo());
        todo.setDeadline(updateTodo.getDeadline());
        todo.setCategory(category);
        todo.setConcluded(updateTodo.isConcluded());

        Todo updatedTodo = todoRepository.save(todo);

        return mapperUtils.parseObject(updatedTodo, TodoDto.class);
    }

    @Override
    public List<TodoDto> findByName(String todo) {
        List<Todo> foundTodo = todoRepository
                .findAllByTodoContainingIgnoreCase(todo);

        return mapperUtils.parseListObjects(
                foundTodo, TodoDto.class);
    }

    @Override
    public TodoDto concludeTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o id informado: " + id));

        todo.setConcluded(!todo.isConcluded());

        if (todo.isConcluded()) {
            todo.setConcludedAt(LocalDate.now());
        } else {
            todo.setConcludedAt(null);
        }

        Todo savedTodo = todoRepository.save(todo);

        return mapperUtils.parseObject(savedTodo, TodoDto.class);
    }

    @Override
    public void delete(Long id) {
        todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o id informado: " + id));
        todoRepository.deleteById(id);
    }
}
