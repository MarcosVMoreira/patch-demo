package com.gbabler.repository;

import com.gbabler.enumeration.Residence;
import com.gbabler.model.entity.PaymentDomain;

public class PaymentRepository {

    public PaymentDomain findById(String id) {
        return PaymentDomain.builder()
                .endereco("Rua Itajai")
                .numero(223)
                .tipoResidencia(Residence.HOUSE)
                .build();
    }

    public void save(PaymentDomain paymentDomain){}
}
