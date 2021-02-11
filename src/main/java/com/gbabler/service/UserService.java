package com.gbabler.service;

import com.gbabler.model.dto.UserRequest;
import com.gbabler.model.entity.UserDomain;
import com.gbabler.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository = new UserRepository();

    /**
     * Check if the id exists
     * Change the values if present
     * Save it
     */

    public void partialUpdate(UserRequest userRequest, String userId) {
        UserDomain userDomain = userRepository.findById(userId);

        log.info("[BEFORE-ENTITY ONE] Nome: {} Idade: {} Maior de idade?: {} Genero: {}",
                userDomain.getName(), userDomain.getAge(), userDomain.getIsAdult(), userDomain.getGender());

        if(!StringUtils.isEmpty(userRequest.getName())) {
            userDomain.setName(userRequest.getName());
        }

        if(userRequest.getAge() != null) {
            userDomain.setAge(userRequest.getAge());
        }

        if(userRequest.getGender() != null) {
            userDomain.setGender(userRequest.getGender());
        }

        if(userRequest.getIsAdult() != null) {
            userDomain.setIsAdult(userRequest.getIsAdult());
        }

        log.info("[AFTER-ENTITY ONE] Nome: {} Idade: {} Maior de idade?: {} Genero: {}",
                userDomain.getName(), userDomain.getAge(), userDomain.getIsAdult(), userDomain.getGender());

        userRepository.save(userDomain);
    }
}
