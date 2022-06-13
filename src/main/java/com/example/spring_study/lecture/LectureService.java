package com.example.spring_study.lecture;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LectureService {

    public List<LectureEntity> getLectures() {
        LectureEntity lecture1 = LectureEntity.builder()
                .name("1차 강의")
                .limitOfEnroll(5)
                .startDateTime(LocalDateTime.of(2022, 1, 1, 9, 0))
                .endDateTime(LocalDateTime.of(2022, 1, 7, 18, 0))
                .build();

        LectureEntity lecture2 = LectureEntity.builder()
                .name("2차 강의")
                .limitOfEnroll(10)
                .startDateTime(LocalDateTime.of(2022, 2, 1, 9, 0))
                .endDateTime(LocalDateTime.of(2022, 2, 15, 18, 0))
                .build();

        return List.of(lecture1, lecture2);
    }


}
