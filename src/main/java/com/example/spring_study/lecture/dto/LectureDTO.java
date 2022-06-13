package com.example.spring_study.lecture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LectureDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    private LocalDateTime startEnrollDateTime;
    @NotNull
    private LocalDateTime endEnrollDateTime;
    @NotNull
    private LocalDateTime startDateTime;
    @NotNull
    private LocalDateTime endDateTime;

    private String location; // optional 비어있으면 온라인
    @Min(0)
    private BigDecimal basePrice; // optional
    @Min(0)
    private BigDecimal maxPrice; // optional
    @Min(0)
    private int limitOfEnroll;


    public boolean isMaxPriceOverZero() {
        /*
         * When a = x / b = y
         * result = a.compareTo(b)
         *
         * If result > 0, x > y
         *    result = 0, x = y
         *    result < 0, x < y
         * */
        return maxPrice.compareTo(BigDecimal.valueOf(0)) > 0;
    }

    public boolean isWrongPricePolicy() {
        return isMaxPriceOverZero() && basePrice.compareTo(maxPrice) > 0;
    }
}
