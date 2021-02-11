package com.gbabler.model.entity;

import com.gbabler.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDomain {

    private String name;
    private Integer age;
    private Boolean isAdult;
    private Gender gender;

}
