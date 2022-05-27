package com.example.spring_study.property;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SomethingController {

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Something.class, new SomethingEditor());
    }

    @GetMapping("/some/{thing}")
    public String getSomething(@PathVariable Something thing) {
        System.out.println(thing);
        return thing.getId().toString();
    }

}
