package com.example.spring_study.lecture;

import com.example.spring_study.lecture.dto.LectureDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class LectureControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }


    @DisplayName("[POST] Create Lecture")
    @WithMockUser(username = "snow", password = "123")
    @Test
    public void testCreateLecture() throws Exception {
        LectureDTO newLecture = LectureDTO.builder()
                .name("Lecture")
                .description("Lecture description")
                .startEnrollDateTime(LocalDateTime.of(2022, 6, 1, 9, 0))
                .endEnrollDateTime(LocalDateTime.of(2022, 6, 7, 18, 0))
                .startDateTime(LocalDateTime.of(2022, 7, 1, 9, 0))
                .endDateTime(LocalDateTime.of(2022, 7, 30, 18, 0))
                .location("서울")
                .basePrice(BigDecimal.valueOf(100))
                .maxPrice(BigDecimal.valueOf(200))
                .limitOfEnroll(10)
                .build();

        mockMvc.perform(post("/api/lectures")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(newLecture))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists());
    }


    @DisplayName("[POST] Create Lecture: Bad Request Empty DTO")
    @WithMockUser(username = "snow", password = "123")
    @Test
    public void testCreateLecture_BadRequest_EmptyDTO() throws Exception {
        LectureDTO newLecture = LectureDTO.builder().build();

        mockMvc.perform(post("/api/lectures")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(newLecture))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @DisplayName("[POST] Create Lecture: Bad Request Invalid Input")
    @WithMockUser(username = "snow", password = "123")
    @Test
    public void testCreateLecture_BadRequest_InvalidInput() throws Exception {
        LectureDTO newLecture = LectureDTO.builder()
                .name("Lecture")
                .description("Lecture description")
                .startEnrollDateTime(LocalDateTime.of(2022, 6, 7, 9, 0))
                .endEnrollDateTime(LocalDateTime.of(2022, 6, 1, 18, 0))
                .startDateTime(LocalDateTime.of(2022, 7, 30, 9, 0))
                .endDateTime(LocalDateTime.of(2022, 7, 1, 18, 0))
                .location("서울")
                .basePrice(BigDecimal.valueOf(1000))
                .maxPrice(BigDecimal.valueOf(200))
                .limitOfEnroll(10)
                .build();

        mockMvc.perform(post("/api/lectures")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(newLecture))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}