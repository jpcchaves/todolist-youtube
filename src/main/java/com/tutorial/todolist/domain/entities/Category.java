package com.tutorial.todolist.domain.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.DETACH,
            fetch = FetchType.EAGER,
            mappedBy = "category")
    private List<Todo> todos = new ArrayList<>();

    public Category() {
    }

    public Category(Long id,
                    String name,
                    List<Todo> todos) {
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

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
