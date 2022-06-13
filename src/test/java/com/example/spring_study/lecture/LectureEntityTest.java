package com.example.spring_study.lecture;

import org.junit.jupiter.api.Test;

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
}