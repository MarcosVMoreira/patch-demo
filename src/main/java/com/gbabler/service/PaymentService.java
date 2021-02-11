package com.gbabler.service;

import com.gbabler.model.dto.PaymentRequest;
import com.gbabler.model.entity.PaymentDomain;
import com.gbabler.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository = new PaymentRepository();

    /**
     * Check if the id exists
     * Change the values if present
     * Save it
     */

    public void partialUpdate(PaymentRequest paymentRequest, String id) {
        PaymentDomain paymentDomain = paymentRepository.findById(id);

        log.info("[BEFORE - PAYMENT ENTITY] Endereco: {} Numero: {} Tipo de Residência: {} ",
                paymentDomain.getEndereco(), paymentDomain.getNumero(), paymentDomain.getTipoResidencia());

        if(!StringUtils.isEmpty(paymentRequest.getAddress())) {
            paymentDomain.setEndereco(paymentRequest.getAddress());
        }

        if(paymentRequest.getNumber() != null) {
            paymentDomain.setNumero(paymentRequest.getNumber());
        }

        if(paymentRequest.getResidence() != null) {
            paymentDomain.setTipoResidencia(paymentRequest.getResidence());
        }

        log.info("[AFTER - PAYMENT ENTITY] Endereco: {} Numero: {} Tipo de Residência: {}",
                paymentDomain.getEndereco(), paymentDomain.getNumero(), paymentDomain.getTipoResidencia());

        paymentRepository.save(paymentDomain);
    }
}
