package com.example.spring_study.lecture;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Table(name = "lectures")
@Entity
public class LectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;
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
    private boolean isOffline;
    private boolean isFree;

    @Enumerated(EnumType.STRING)
    private LectureStatus lectureStatus;

}
