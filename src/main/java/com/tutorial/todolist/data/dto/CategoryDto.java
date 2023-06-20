package com.tutorial.todolist.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    private Long id;
    private String name;
    @JsonIgnore
    private List<TodoDto> todos = new ArrayList<>();

    public CategoryDto() {
    }

    public CategoryDto(Long id,
                       String name,
                       List<TodoDto> todos) {
        this.id = id;
        this.name = name;
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDto> todos) {
        this.todos = todos;
    }
}
