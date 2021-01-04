package com.gbabler.service;

import com.gbabler.model.dto.ExampleRequestTwo;
import com.gbabler.model.dto.Residence;
import com.gbabler.model.entity.ExampleEntityTwo;
import com.gbabler.repository.RepositoryTwo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceTwo {

    private final RepositoryTwo repositoryTwo;

    public void partialUpdate(ExampleRequestTwo requestTwo) {
        //Here would have a findById method (entity.findById())
        ExampleEntityTwo entityTwo = repositoryTwo.findById("123");

        log.info("[BEFORE-ENTITY ONE] Endereco: {} Numero: {} Tipo de Residência: {} ",
                entityTwo.getEndereco(), entityTwo.getNumero(), entityTwo.getTipoResidencia());

        new PatchImpl<>(requestTwo, entityTwo)
                .updateIfPresent(ExampleRequestTwo::getAddress, ExampleEntityTwo::setEndereco)
                .updateIfPresent(ExampleRequestTwo::getNumber, ExampleEntityTwo::setNumero)
                .updateIfPresent(ExampleRequestTwo::getResidence, ExampleEntityTwo::setTipoResidencia);

        log.info("[AFTER-ENTITY ONE] Endereco: {} Numero: {} Tipo de Residência: {}",
                entityTwo.getEndereco(), entityTwo.getNumero(), entityTwo.getTipoResidencia());

        //Here we would save the updated entity on the database.
    }
}
