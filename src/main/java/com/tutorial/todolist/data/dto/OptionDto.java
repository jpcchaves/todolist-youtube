package com.tutorial.todolist.data.dto;

public class OptionDto<V, L> {
    private V value;
    private L label;

    public OptionDto() {
    }

    public OptionDto(V value,
                     L label) {
        this.value = value;
        this.label = label;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public L getLabel() {
        return label;
    }

    public void setLabel(L label) {
        this.label = label;
    }
}
