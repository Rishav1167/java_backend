package com.springmessagingapp.controllers;

import com.springmessagingapp.entities.Greetings;
import com.springmessagingapp.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<Greetings>> greeting(
            @RequestParam (value = "firstname" , defaultValue = "")String firstname,
            @RequestParam (value = "lastname",defaultValue = "")String lastname)
    {

         return new ResponseEntity<>(
                 greetingService.getGreetings(),
                 HttpStatus.OK);
    }

    @PostMapping("post")
    public ResponseEntity<Greetings> gettinggreeting(
            @RequestParam(value = "firstname" , defaultValue = "")String firstname,
            @RequestParam(value = "lastname" , defaultValue = "") String lastname
    ) {
        return new ResponseEntity<>(greetingService.addGreeting(firstname,lastname), HttpStatus.OK);
    }

    @GetMapping("findByid")
    public ResponseEntity<Greetings> getGreetingById(@RequestParam("id") long id) {
        return new ResponseEntity<>(greetingService.getGreetingById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Greetings>updatingGreeting(
            @PathVariable long id,
            @RequestParam(value = "firstname" , defaultValue = "")String firstname,
            @RequestParam(value = "lastname" , defaultValue = "") String lastname
    ){
        return new ResponseEntity<>(greetingService.updateGreetingById(id, firstname, lastname), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Greetings> deletingGreeting(@PathVariable long id) {
        if (greetingService.deleteGreetingById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
