package com.gbabler.repository;

import com.gbabler.model.dto.Residence;
import com.gbabler.model.entity.PaymentDomain;

public class PaymentRepository {

    public PaymentDomain findById(String id) {
        return PaymentDomain.builder()
                .endereco("Rua Itajai")
                .numero(223)
                .tipoResidencia(Residence.HOUSE)
                .build();
    }
}
