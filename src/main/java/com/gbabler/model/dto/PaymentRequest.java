package com.gbabler.model.dto;

import com.gbabler.enumeration.Residence;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest {

    private String address;
    private Integer number;
    private Residence residence;

}
