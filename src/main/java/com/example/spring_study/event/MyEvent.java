package com.example.spring_study.event;

import lombok.Getter;

@Getter
public class MyEvent {

    private int data;
    private Object source;

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }


}
