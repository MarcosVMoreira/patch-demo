package com.gbabler.model.entity;

import com.gbabler.model.dto.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ExampleEntityOne {

    private String nome;
    private Integer idade;
    private Boolean maiorDeIdade;
    private Gender genero;

}
