package com.springmessagingapp.controllers;

import com.springmessagingapp.entities.Greetings;
import com.springmessagingapp.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/message")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetings")
    public ResponseEntity<Greetings> greetings(@RequestParam (value = "name" , defaultValue = "world") String name) {
        return new ResponseEntity<>(new Greetings(counter.incrementAndGet(),String.format(template,name)), HttpStatus.OK);
    }

    @GetMapping("/simple")
    public ResponseEntity<String> simpleGreeting() {
        return new ResponseEntity<>(greetingService.getSimpleGreeting(), HttpStatus.OK);
    }

}
