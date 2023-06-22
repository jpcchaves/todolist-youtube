package com.tutorial.todolist.repository;

import com.tutorial.todolist.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByNameContainingIgnoreCase(String name);
}
