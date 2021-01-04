package com.gbabler.controller;

import com.gbabler.model.dto.ExampleRequestOne;
import com.gbabler.model.dto.ExampleRequestTwo;
import com.gbabler.service.ServiceOne;
import com.gbabler.service.ServiceTwo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controllerTwo")
@RequiredArgsConstructor
public class ControllerTwo {

    private final ServiceTwo serviceTwo;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void partialUpdate(@RequestBody ExampleRequestTwo requestTwo) {
        serviceTwo.partialUpdate(requestTwo);
    }
}