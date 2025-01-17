package com.dockerize.rest_service.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SampleController {
    
    @GetMapping("/")
    public String getSampleString() {
        return new String("Testing Dockerisation of this Springboot app.");
    }
    
}
