package com.example.spring_study.index;

import com.example.spring_study.lecture.LectureController;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class IndexController {

    @GetMapping("/")
    public RepresentationModel<?> index(){
        RepresentationModel<?> representationModel = new RepresentationModel<>();
        representationModel.add(linkTo(LectureController.class).withRel("lectures"));
        return representationModel;
    }

}
