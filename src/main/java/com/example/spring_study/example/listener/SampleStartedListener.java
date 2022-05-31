package com.example.spring_study.example.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("=================================================================");
        System.out.println("[Sample STARTED Listener]");
        System.out.println("Application Started");
        System.out.println("=================================================================");
    }

}
