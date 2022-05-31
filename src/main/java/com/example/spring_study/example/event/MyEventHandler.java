package com.example.spring_study.example.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

        @Order(Ordered.HIGHEST_PRECEDENCE + 2) // 실행 우선순위
//    @Async // 비동기 실행 (Order 는 무의미) @EnableAsync 가 필요
    @EventListener
    public void handle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler Data: " + event.getData());
    }

}
