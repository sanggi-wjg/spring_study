package com.example.spring_study.lecture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LectureDTO {

    private String name;
    private String description;

    private LocalDateTime startEnrollDateTime;
    private LocalDateTime endEnrollDateTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String location; // optional 비어있으면 온라인
    private BigDecimal basePrice; // optional
    private BigDecimal maxPrice; // optional
    private int limitOfEnroll;

}
