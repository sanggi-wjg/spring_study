package com.example.spring_study.lecture.resource;

import com.example.spring_study.lecture.LectureEntity;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;


@Getter
public class LectureResource extends RepresentationModel<LectureResource> {

    @JsonUnwrapped
    private LectureEntity lectureEntity;

    public LectureResource(LectureEntity lectureEntity) {
        this.lectureEntity = lectureEntity;
    }


}
