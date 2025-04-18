package com.springmessagingapp.controllers;

import com.springmessagingapp.entities.Greetings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings")
    public ResponseEntity<Greetings> greetings(@RequestParam (value = "name" , defaultValue = "world") String name) {
        return new ResponseEntity<>(new Greetings(counter.incrementAndGet(),String.format(template,name)), HttpStatus.OK);
    }
}
