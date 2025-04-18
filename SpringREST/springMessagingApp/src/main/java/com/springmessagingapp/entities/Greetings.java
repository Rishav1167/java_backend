package com.springmessagingapp.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greetings {
    private long id;
    private String content;

    public Greetings(long id, String content) {
        this.id = id;
        this.content = content;
    }
}