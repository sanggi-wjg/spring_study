package com.example.spring_study.example.scope;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Single {

    @Autowired
    private Proto proto;

}
