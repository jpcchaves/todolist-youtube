package com.tutorial.todolist.service;

import com.tutorial.todolist.data.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();

    CategoryDto getById(Long id);

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(Long id,
                       CategoryDto categoryDto);
}
