package com.example.spring_study.lecture;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureEntity {

    private String name;
    private int limitOfEnrollment;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

}
