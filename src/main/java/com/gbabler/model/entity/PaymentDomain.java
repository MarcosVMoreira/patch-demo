package com.gbabler.model.entity;

import com.gbabler.model.dto.Residence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaymentDomain {

    private String endereco;
    private Integer numero;
    private Residence tipoResidencia;

}
