package com.intro;


import com.intro.beans.Employee;
import com.intro.controller.HelloRestController;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IntroApplication {
    private static final Logger log = LoggerFactory.getLogger(IntroApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IntroApplication.class, args);
        log.info("Checking Context: {}", context.getBean(Employee.class));
    }

}
