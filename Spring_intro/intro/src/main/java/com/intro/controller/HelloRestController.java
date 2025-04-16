package com.intro.controller;

import org.slf4j.Logger;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    private static final Logger logger = LoggerFactory.getLogger(HelloRestController.class.getName());
    @GetMapping("/rest")
    public String hello() {
        logger.info("handling rest request to \"/rest\" ");
        return "hello world from rest controller";
    }
}
