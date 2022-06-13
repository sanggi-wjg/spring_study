package com.example.spring_study.lecture;

import com.example.spring_study.lecture.dto.LectureDTO;
import com.example.spring_study.lecture.dto.LectureValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Controller
@RequestMapping(value = "/api/lectures", produces = MediaTypes.HAL_JSON_VALUE)
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureValidator lectureValidator;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    LectureService lectureService;

//    @GetMapping()
//    public String lectures(Model model) {
//        model.addAttribute("lectures", lectureService.getLectures());
//        return "lecture/list";
//    }

    @PostMapping()
    public ResponseEntity createLecture(@RequestBody @Valid LectureDTO lectureDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        lectureValidator.validate(lectureDTO, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        // mapping dto to entity
        LectureEntity newLecture = lectureRepository.save(
                modelMapper.map(lectureDTO, LectureEntity.class)
        );
        // create uri
        URI createdUri = linkTo(LectureController.class).slash(newLecture.getId()).toUri();
        System.out.println("createdUri = " + createdUri.getRawFragment());
        return ResponseEntity.created(createdUri).body(newLecture);
    }

}
