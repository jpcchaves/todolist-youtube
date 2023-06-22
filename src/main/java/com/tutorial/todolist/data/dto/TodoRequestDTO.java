package com.tutorial.todolist.data.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TodoRequestDTO {
    @NotBlank(message = "A tarefa é obrigatória")
    private String todo;
    @NotNull(message = "A situação da tarefa é obrigatória")
    private boolean concluded;
    private boolean active;
    @FutureOrPresent(message = "O prazo deve ser uma data futura")
    private LocalDate deadline;
    @NotNull(message = "Informe uma categoria para salvar a tarefa")
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
