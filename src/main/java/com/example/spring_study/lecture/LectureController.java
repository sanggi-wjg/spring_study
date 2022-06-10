package com.example.spring_study.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller()
public class LectureController {

    @Autowired
    LectureService lectureService;

    @GetMapping("/lecture/list")
    public String lectures(Model model) {
        model.addAttribute("lectures", lectureService.getLectures());
        return "lecture/list";
    }

}
