package com.example.spring_study.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/users/create")
    public User createUser(@RequestBody User user) {
        return user;
    }

}
