package com.tutorial.todolist.service.impl;

import com.tutorial.todolist.data.dto.CategoryDto;
import com.tutorial.todolist.domain.entities.Category;
import com.tutorial.todolist.repository.CategoryRepository;
import com.tutorial.todolist.service.CategoryService;
import com.tutorial.todolist.utils.mapper.MapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final MapperUtils mapperUtils;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               MapperUtils mapperUtils) {
        this.categoryRepository = categoryRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryListDto = mapperUtils.parseListObjects(categoryList, CategoryDto.class);

        return categoryListDto;
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o id informado: " + id));
        return mapperUtils.parseObject(category, CategoryDto.class);
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = mapperUtils.parseObject(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return mapperUtils.parseObject(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto update(Long id,
                              CategoryDto categoryDto) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o id informado: " + id));

        category.setName(categoryDto.getName());

        Category updatedCategory = categoryRepository.save(category);

        return mapperUtils.parseObject(updatedCategory, CategoryDto.class);
    }
}
