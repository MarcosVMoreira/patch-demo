package com.gbabler.service;

import com.gbabler.model.dto.UserRequest;
import com.gbabler.model.entity.UserDomain;
import com.gbabler.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void partialUpdate(UserRequest requestOne, String userId) {
        UserDomain userDomain = userRepository.findById(userId);

        log.info("[BEFORE-ENTITY ONE] Nome: {} Idade: {} Maior de idade?: {} Genero: {}",
                userDomain.getNome(), userDomain.getIdade(), userDomain.getMaiorDeIdade(), userDomain.getGenero());

        new PatchImpl<>(requestOne, userDomain)
                .updateIfPresent(UserRequest::getName, UserDomain::setNome)
                .updateIfPresent(UserRequest::getAge, UserDomain::setIdade)
                .updateIfPresent(UserRequest::getIsAdult, UserDomain::setMaiorDeIdade)
                .updateIfPresent(UserRequest::getGender, UserDomain::setGenero);

        log.info("[AFTER-ENTITY ONE] Nome: {} Idade: {} Maior de idade?: {} Genero: {}",
                userDomain.getNome(), userDomain.getIdade(), userDomain.getMaiorDeIdade(), userDomain.getGenero());

        //Here we would save the updated entity on the database.
    }
}
