package com.example.spring_study.lecture;

import com.example.spring_study.global.common.ErrorResource;
import com.example.spring_study.lecture.dto.LectureDTO;
import com.example.spring_study.lecture.resource.LectureResource;
import com.example.spring_study.lecture.valid.LectureValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    @GetMapping()
    public ResponseEntity lectures(Pageable pageable, PagedResourcesAssembler<LectureEntity> assembler) {
        Page<LectureEntity> page = lectureRepository.findAll(pageable);
        PagedModel<EntityModel<LectureEntity>> entityModels = assembler.toModel(page);
        return ResponseEntity.ok(entityModels);
    }

    @PostMapping()
    public ResponseEntity createLecture(@RequestBody @Valid LectureDTO lectureDTO, Errors errors) {
        lectureValidator.validate(lectureDTO, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(new ErrorResource(errors));
        }

        LectureEntity lecture = modelMapper.map(lectureDTO, LectureEntity.class);
        lecture.update();
        LectureEntity newLecture = lectureRepository.save(lecture);

        // create uri
        WebMvcLinkBuilder linkBuilder = linkTo(LectureController.class).slash(newLecture.getId());
        URI createdUri = linkBuilder.toUri();

        LectureResource lectureResource = new LectureResource(newLecture);
        lectureResource.add(linkBuilder.withSelfRel());
        lectureResource.add(linkTo(LectureController.class).withRel("query-events"));
        lectureResource.add(linkTo(LectureController.class).withRel("update-event"));

        return ResponseEntity.created(createdUri).body(lectureResource);
    }

}
