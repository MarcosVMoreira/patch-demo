package com.gbabler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExampleRequestTwo {

    private String address;
    private Integer number;
    private Residence residence;

}
