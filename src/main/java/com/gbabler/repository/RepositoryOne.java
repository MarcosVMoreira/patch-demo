package com.gbabler.repository;

import com.gbabler.model.dto.Gender;
import com.gbabler.model.entity.ExampleEntityOne;

public class RepositoryOne {
    public ExampleEntityOne findById(String id) {
        return ExampleEntityOne.builder()
                .nome("Gabriel")
                .idade(25)
                .maiorDeIdade(true)
                .genero(Gender.MALE)
                .build();
    }
}
