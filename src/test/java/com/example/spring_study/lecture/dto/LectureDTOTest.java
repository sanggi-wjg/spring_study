package com.example.spring_study.lecture.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LectureDTOTest {

    @Test
    public void testMaxPrice() throws Exception {
        // given
        LectureDTO lectureDTO = LectureDTO.builder()
                .maxPrice(BigDecimal.valueOf(100))
                .build();

        // when
        boolean res = lectureDTO.isMaxPriceOverZero();

        // then
        assertTrue(res);
    }

    @Test
    public void testMaxPrice_ZeroValue() throws Exception {
        // given
        LectureDTO lectureDTO = LectureDTO.builder()
                .maxPrice(BigDecimal.valueOf(0))
                .build();

        // when
        boolean res = lectureDTO.isMaxPriceOverZero();

        // then
        assertFalse(res);
    }

    @Test
    public void testIsWrongPrice() throws Exception {
        // given
        LectureDTO lectureDTO = LectureDTO.builder()
                .basePrice(BigDecimal.valueOf(0))
                .maxPrice(BigDecimal.valueOf(0))
                .build();

        // when
        boolean res = lectureDTO.isWrongPricePolicy();

        // then
        assertFalse(res);
    }

    @Test
    public void testIsWrongPrice_WrongInput() throws Exception {
        // given
        LectureDTO lectureDTO = LectureDTO.builder()
                .basePrice(BigDecimal.valueOf(10))
                .maxPrice(BigDecimal.valueOf(1))
                .build();

        // when
        boolean res = lectureDTO.isWrongPricePolicy();

        // then
        assertTrue(res);
    }

}