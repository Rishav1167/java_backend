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
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/simple")
    public ResponseEntity<String> simpleGreeting() {
        return new ResponseEntity<>(greetingService.getSimpleGreeting(), HttpStatus.OK);
    }

    @GetMapping("/greeting")
    public ResponseEntity<Greetings> greeting(
            @RequestParam (value = "firstname" , defaultValue = "")String firstname,
            @RequestParam (value = "lastname",defaultValue = "")String lastname)
    {
        if ((firstname == null || firstname.isEmpty()) && (lastname == null || lastname.isEmpty())) {
            firstname = "World";
            lastname = "";
        }
        if((firstname == null || firstname.isEmpty())){
            firstname = lastname;
            lastname = "";
        }
         return new ResponseEntity<>(
                 greetingService.getGreeting(firstname,lastname),
                 HttpStatus.OK);
    }
}
