package com.example.spring_study.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserController {

    @PostMapping("/users/create")
    public User createUser(@RequestBody User user) {
        return user;
    }


    @GetMapping("/users/2")
    public EntityModel<User> getUser() {
        User user = new User();
        user.setUsername("Snow");
        user.setPassword("123");

        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getUser());
        userEntityModel.add(linkBuilder.withRel("self"));

        return userEntityModel;
    }

}
