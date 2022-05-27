package com.example.spring_study.property;


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
