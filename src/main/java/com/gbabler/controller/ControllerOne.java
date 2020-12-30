package com.gbabler.controller;

import com.gbabler.model.dto.ExampleRequestOne;
import com.gbabler.service.ServiceOne;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controllerOne")
@RequiredArgsConstructor
public class ControllerOne {

    private final ServiceOne serviceOne;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void partialUpdate(@RequestBody ExampleRequestOne requestOne) {
        serviceOne.partialUpdate(requestOne);
    }
}
