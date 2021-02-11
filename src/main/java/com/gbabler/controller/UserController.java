package com.gbabler.controller;

import com.gbabler.model.dto.UserRequest;
import com.gbabler.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialUpdate(
            @RequestBody UserRequest userRequest,
            @PathVariable(name = "id") String userId) {

        userService.partialUpdate(userRequest, userId);

        return ResponseEntity.noContent().build();
    }

}
