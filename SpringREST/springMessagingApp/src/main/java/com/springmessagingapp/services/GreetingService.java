package com.springmessagingapp.services;

import com.springmessagingapp.entities.Greetings;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getSimpleGreeting() {
        return "Hello World";
    }

    public Greetings getGreeting(String firstname , String lastname) {
        return new Greetings("Hello " + firstname +" " +  lastname);
    }
}
