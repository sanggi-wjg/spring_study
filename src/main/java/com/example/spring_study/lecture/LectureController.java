package com.example.spring_study.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Controller
@RequestMapping(value = "/api/lectures", produces = MediaTypes.HAL_JSON_VALUE)
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

//    @Autowired
//    LectureService lectureService;

//    @GetMapping()
//    public String lectures(Model model) {
//        model.addAttribute("lectures", lectureService.getLectures());
//        return "lecture/list";
//    }

    @PostMapping()
    public ResponseEntity createLecture(@RequestBody LectureEntity lecture) {
        LectureEntity newLecture = lectureRepository.save(lecture);
        URI createdUri = linkTo(LectureController.class).slash(newLecture.getId()).toUri();
        return ResponseEntity.created(createdUri).body(newLecture);
    }

}
