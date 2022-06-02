package com.example.spring_study.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initMember() {
        if (!userService.isExistMemberByUsername("snow")) {
            Member newMember = userService.createUser("snow", "123");
        }
    }

    @PostMapping("/users/create")
    public Member createUser(@RequestBody Member member) {
        return member;
    }


    @GetMapping("/users/2")
    public EntityModel<Member> getUser() {
        Member member = new Member();
        member.setUsername("Snow");
        member.setPassword("123");

        EntityModel<Member> userEntityModel = EntityModel.of(member);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getUser());
        userEntityModel.add(linkBuilder.withRel("self"));

        return userEntityModel;
    }

}
