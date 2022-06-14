package com.example.spring_study.lecture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LectureEntityTest {

    @Test
    public void testBuilder() {
        LectureEntity lecture = LectureEntity.builder()
                .name("Lecture")
                .description("Lecture description")
                .build();
        assertNotNull(lecture);
    }

    @Test
    public void testEntity() throws Exception {
        // given
        String lectureName = "Lecture";
        String lectureDesc = "Lecture description";

        // when
        LectureEntity lecture = new LectureEntity();
        lecture.setName(lectureName);
        lecture.setDescription(lectureDesc);

        // then
        assertEquals(lecture.getName(), lectureName);
        assertEquals(lecture.getDescription(), lectureDesc);
    }


//    private static Object[] testParams() {
//        return new Object[]{
//                new Object[]{BigDecimal.valueOf(0), BigDecimal.valueOf(0), "Seoul", true},
//                new Object[]{BigDecimal.valueOf(0), BigDecimal.valueOf(1), "Seoul", false},
//                new Object[]{BigDecimal.valueOf(1), BigDecimal.valueOf(1), "Seoul", false},
//        };
//    }

    private static Stream<Arguments> testParams() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(0), BigDecimal.valueOf(0), "Seoul", true),
                Arguments.of(BigDecimal.valueOf(0), BigDecimal.valueOf(1), "Seoul", false),
                Arguments.of(BigDecimal.valueOf(1), BigDecimal.valueOf(1), "Seoul", false)
        );
    }

    @ParameterizedTest(name = "{index} => basePrice={0}, maxPrice={1}, location={2}, isFree={3}")
    @MethodSource("testParams")
    public void testUpdate_IsFree(BigDecimal basePrice, BigDecimal maxPrice, String location, boolean isFree) throws Exception {
        // given
        LectureEntity lecture = LectureEntity.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .location(location)
                .build();

        // when
        lecture.update();

        // then
        assertEquals(lecture.isFree(), isFree);
    }

}