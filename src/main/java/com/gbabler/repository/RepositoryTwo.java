package com.gbabler.repository;

import com.gbabler.model.dto.Residence;
import com.gbabler.model.entity.ExampleEntityTwo;

public class RepositoryTwo {

    public ExampleEntityTwo findById(String id) {
        return ExampleEntityTwo.builder()
                .endereco("Rua Itajai")
                .numero(223)
                .tipoResidencia(Residence.HOUSE)
                .build();
    }
}
