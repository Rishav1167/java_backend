package com.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/query")
    public String query(@RequestParam String name) {
        return "Hello " + name;
    }
}