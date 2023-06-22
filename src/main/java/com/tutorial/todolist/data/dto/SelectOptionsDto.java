package com.tutorial.todolist.data.dto;

import java.util.ArrayList;
import java.util.List;

public class SelectOptionsDto {
    private List<OptionDto> options = new ArrayList<>();

    public SelectOptionsDto() {
    }

    public SelectOptionsDto(List<OptionDto> options) {
        this.options = options;
    }

    public List<OptionDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDto> options) {
        this.options = options;
    }
}
