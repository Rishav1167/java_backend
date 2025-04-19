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

    public Greetings getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    public List<Greetings> getGreetings() {
        return greetingRepository.findAll();
    }

    public Greetings updateGreetingById(long id, String firstname , String lastname) {
        if (!greetingRepository.existsById(id)) {
            return null;
        }
        Greetings greeting = Greetings.builder().content(("Hello " + firstname + " " + lastname).trim()).build();
        greeting.setId(id);
        greetingRepository.save(greeting);
        return greeting;
    }

    public boolean deleteGreetingById(long id) {
        if (!greetingRepository.existsById(id)) {
            return false;
        }
        greetingRepository.deleteById(id);
        greetingRepository.flush();
        return !greetingRepository.existsById(id);
    }
}
