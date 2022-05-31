package com.example.spring_study.example.property;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Something {

    private Integer id;
    private String title;

    public Something(Integer id) {
        this.id = id;
    }
}
