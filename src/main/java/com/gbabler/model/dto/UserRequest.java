package com.gbabler.model.dto;

import com.gbabler.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private Integer age;
    private Boolean isAdult;
    private Gender gender;

}