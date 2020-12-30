package com.gbabler.service;

import com.gbabler.model.dto.ExampleRequestOne;
import com.gbabler.model.dto.Gender;
import com.gbabler.model.entity.ExampleEntityOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceOne {

    public void partialUpdate(ExampleRequestOne requestOne) {
        //Here would have a findById method (entity.findById())
        ExampleEntityOne entityOne = ExampleEntityOne.builder()
                .nome("Gabriel")
                .idade(25)
                .maiorDeIdade(true)
                .genero(Gender.MALE)
                .build();

        log.info("[BEFORE-ENTITY ONE] Nome: {} Idade: {} Maior de idade?: {} Genero: {}",
                entityOne.getNome(), entityOne.getIdade(), entityOne.getMaiorDeIdade(), entityOne.getGenero());

        new PatchImpl<>(requestOne, entityOne)
                .updateIfPresent(ExampleRequestOne::getName, ExampleEntityOne::setNome)
                .updateIfPresent(ExampleRequestOne::getAge, ExampleEntityOne::setIdade)
                .updateIfPresent(ExampleRequestOne::getIsAdult, ExampleEntityOne::setMaiorDeIdade)
                .updateIfPresent(ExampleRequestOne::getGender, ExampleEntityOne::setGenero);

        log.info("[AFTER-ENTITY ONE] Nome: {} Idade: {} Maior de idade?: {} Genero: {}",
                entityOne.getNome(), entityOne.getIdade(), entityOne.getMaiorDeIdade(), entityOne.getGenero());

        //Here we would save the updated entity on the database.
    }
}
