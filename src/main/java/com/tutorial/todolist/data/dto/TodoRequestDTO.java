package com.tutorial.todolist.data.dto;

import java.time.LocalDate;

public class TodoRequestDTO {
    private String todo;
    private boolean concluded;
    private boolean active;
    private LocalDate deadline;
    private Long categoryId;

    public TodoRequestDTO() {
    }

    public TodoRequestDTO(String todo,
                          boolean concluded,
                          boolean active,
                          LocalDate deadline,
                          Long categoryId) {
        this.todo = todo;
        this.concluded = concluded;
        this.active = active;
        this.deadline = deadline;
        this.categoryId = categoryId;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
