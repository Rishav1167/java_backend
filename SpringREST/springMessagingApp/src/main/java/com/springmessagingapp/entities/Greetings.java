package com.springmessagingapp.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Greetings {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String content;

    public Greetings(String content) {
        this.id = counter.incrementAndGet();
        this.content = content;
    }
}