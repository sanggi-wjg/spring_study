package com.example.spring_study.example.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpELRunner implements ApplicationRunner {

    @Value("#{1 + 1}")
    int value;

    @Value("#{'Hello ' + 'world'}")
    String greeting;

    @Value("Hello")
    String hello;

    @Value("#{1 eq 1}")
    boolean isEqual;

    @Value("#{'Hello ' + '${app.name}'}")
    String myAppName;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=================================================================");
        System.out.println("[SpEL]");
        System.out.println("value: " + value);
        System.out.println("hello: " + hello);
        System.out.println("greeting: " + greeting);
        System.out.println("isEqual: " + isEqual);
        System.out.println("myAppName: " + myAppName);
        System.out.println("=================================================================");
    }
}
