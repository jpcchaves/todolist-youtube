package com.tutorial.todolist.repository;

import com.tutorial.todolist.domain.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByTodoContainingIgnoreCase(String todo);
}
