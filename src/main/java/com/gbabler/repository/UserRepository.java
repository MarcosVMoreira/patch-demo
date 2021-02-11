package com.gbabler.repository;

import com.gbabler.enumeration.Gender;
import com.gbabler.model.entity.UserDomain;

public class UserRepository {
    public UserDomain findById(String id) {
        return UserDomain.builder()
                .name("Gabriel")
                .age(25)
                .isAdult(true)
                .gender(Gender.MALE)
                .build();
    }
    public void save(UserDomain userDomain){}
}
