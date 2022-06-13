package com.example.spring_study.lecture.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class LectureValidator {

    public void validate(LectureDTO lectureDTO, Errors errors) {
        if (lectureDTO.isWrongPricePolicy()) {
            errors.rejectValue("basePrice", "wrongValue", "basePrice is wrong");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is wrong");
        }

        LocalDateTime endDateTime = lectureDTO.getEndDateTime();
        if (endDateTime.isBefore(lectureDTO.getStartDateTime()) ||
                endDateTime.isBefore(lectureDTO.getStartEnrollDateTime()) ||
                endDateTime.isBefore(lectureDTO.getEndEnrollDateTime())) {
            errors.rejectValue("endDateTime", "wrongValue", "endDateTime is wrong");
        }
    }

}
