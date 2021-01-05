package com.gbabler.repository;

import com.gbabler.model.dto.Gender;
import com.gbabler.model.entity.UserDomain;

public class UserRepository {
    public UserDomain findById(String id) {
        return UserDomain.builder()
                .nome("Gabriel")
                .idade(25)
                .maiorDeIdade(true)
                .genero(Gender.MALE)
                .build();
    }
}
