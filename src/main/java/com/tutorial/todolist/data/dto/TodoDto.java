package com.tutorial.todolist.data.dto;


import java.time.LocalDate;
import java.util.Date;

public class TodoDto {
    private Long id;
    private String todo;
    private boolean concluded;
    private boolean active;
    private LocalDate deadline;
    private CategoryDto category;
    private Date concludedAt;
    private Date createdAt;
    private Date updatedAt;

    public TodoDto() {
    }

    public TodoDto(Long id,
                   String todo,
                   boolean concluded,
                   boolean active,
                   LocalDate deadline,
                   CategoryDto category,
                   Date concludedAt,
                   Date createdAt,
                   Date updatedAt) {
        this.id = id;
        this.todo = todo;
        this.concluded = concluded;
        this.active = active;
        this.deadline = deadline;
        this.category = category;
        this.concludedAt = concludedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public Date getConcludedAt() {
        return concludedAt;
    }

    public void setConcludedAt(Date concludedAt) {
        this.concludedAt = concludedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
