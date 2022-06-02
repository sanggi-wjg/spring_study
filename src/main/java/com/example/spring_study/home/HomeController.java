package com.example.spring_study.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Snow");
        return "hello";
    }

    @GetMapping("/me")
    public String me(Model model) {
        return "me";
    }

}
