package com.example.spring_study.example.non_null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class NonNullRunner implements ApplicationRunner {

    @Autowired
    WhatClass whatClass;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
        @NonNull 사용 방법

        툴을 이용해 컴파일 시점에 최대한 오류 줄이는 것
        1. settings / compiler 에 CONFIGURE ANNOTATIONS... 클릭
        2. Nullable 과 NotNull 탭에서 각각 spring framework 의 Nullable 과 NonNull 을 추가
        3. IDE 재시작
        * */
        System.out.println("=================================================================");
        System.out.println("[Non-Null]");
        whatClass.create(null);
        System.out.println("=================================================================");
    }
}
