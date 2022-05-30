package com.example.spring_study.non_null;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class WhatClass {

    @NonNull
    public String create(String name) {
        return "What " + name;
    }

}
