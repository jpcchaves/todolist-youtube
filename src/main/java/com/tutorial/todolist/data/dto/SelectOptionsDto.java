package com.tutorial.todolist.data.dto;

import java.util.ArrayList;
import java.util.List;

public class SelectOptionsDto<V, L> {
    private List<OptionDto<V, L>> options = new ArrayList<>();

    public SelectOptionsDto() {
    }

    public SelectOptionsDto(List<OptionDto<V, L>> options) {
        this.options = options;
    }

    public List<OptionDto<V, L>> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDto<V, L>> options) {
        this.options = options;
    }
}
