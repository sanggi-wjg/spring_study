package com.example.spring_study.home;

import com.example.spring_study.home.converter.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("")
    public String index() {
        return "home";
    }

//    @GetMapping("/hello")
//    public String hello(Model model) {
//        model.addAttribute("name", "Snow");
//        return "hello";
//    }

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam("id") Person person) {
        model.addAttribute("name", person.getName());
        return "hello";
    }

    @GetMapping("/me")
    public String me(Model model) {
        return "me";
    }

}
