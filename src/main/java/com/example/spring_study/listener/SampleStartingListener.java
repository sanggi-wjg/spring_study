package com.example.spring_study.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class SampleStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("=================================================================");
        System.out.println("[Sample STARTING Listener]");
        System.out.println("Application Starting");
        System.out.println("=================================================================");
    }

}
