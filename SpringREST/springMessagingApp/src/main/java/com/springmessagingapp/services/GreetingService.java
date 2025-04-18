package com.springmessagingapp.services;

import com.springmessagingapp.entities.Greetings;
import com.springmessagingapp.repositories.IGreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private final IGreetingRepository greetingRepository;

    public GreetingService(IGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    public String getSimpleGreeting() {
        return "Hello World";
    }

    public Greetings addGreeting(String firstname , String lastname) {
        Greetings greeting = Greetings.builder().content(("Hello " + firstname + " " + lastname).trim()).build();
        greetingRepository.save(greeting);
        return greeting;
    }

    public List<Greetings> getGreetings() {
        return greetingRepository.findAll();
    }
}
