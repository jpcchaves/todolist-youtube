package com.tutorial.todolist.utils.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperUtils {

    private final ModelMapper mapper;

    public MapperUtils(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <O, D> D parseObject(O origin,
                                Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public <O, D> List<D> parseListObjects(List<O> origin,
                                           Class<D> destination) {

        List<D> destinationObjects = new ArrayList<>();

        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
