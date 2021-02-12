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

        new PatchImpl<>(paymentRequest, paymentDomain)
                .updateIfPresent(PaymentRequest::getAddress, PaymentDomain::setEndereco)
                .updateIfPresent(PaymentRequest::getNumber, PaymentDomain::setNumero)
                .updateIfPresent(PaymentRequest::getResidence, PaymentDomain::setTipoResidencia);

        log.info("[AFTER - PAYMENT ENTITY] Endereco: {} Numero: {} Tipo de Residência: {}",
                paymentDomain.getEndereco(), paymentDomain.getNumero(), paymentDomain.getTipoResidencia());

        paymentRepository.save(paymentDomain);
    }
}
