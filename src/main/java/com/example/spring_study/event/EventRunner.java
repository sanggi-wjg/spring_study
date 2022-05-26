package com.example.spring_study.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventRunner implements ApplicationRunner {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
        * 이벤트 사용 예시
        * https://velog.io/@ljinsk3/Spring-Events
        * */
        System.out.println("=================================================================");
        eventPublisher.publishEvent(new MyEvent(this, 100));
        System.out.println("=================================================================");
    }

}
