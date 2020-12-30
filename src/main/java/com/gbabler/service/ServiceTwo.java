package com.gbabler.service;

import com.gbabler.model.dto.ExampleRequestTwo;
import com.gbabler.model.dto.Residence;
import com.gbabler.model.entity.ExampleEntityTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceTwo {

    public void partialUpdate(ExampleRequestTwo requestTwo) {
        //Here would have a findById method (entity.findById())
        ExampleEntityTwo entityTwo = ExampleEntityTwo.builder()
                .endereco("Rua Itajai")
                .numero(223)
                .tipoResidencia(Residence.HOUSE)
                .build();

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
