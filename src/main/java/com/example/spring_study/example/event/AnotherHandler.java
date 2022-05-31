package com.example.spring_study.example.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

//    @Async
    @EventListener
    public void handle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("AnotherHandler Data: " + event.getData());
    }

}
