package com.example.spring_study.lecture;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LectureController.class)
//@ExtendWith(SpringExtension.class)
class LectureControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    LectureRepository lectureRepository;

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
        LectureEntity newLecture = LectureEntity.builder()
                .name("Lecture")
                .description("Lecture description")
                .startEnrollDateTime(LocalDateTime.of(2022, 6, 1, 9, 0))
                .endEnrollDateTime(LocalDateTime.of(2022, 6, 7, 18, 0))
                .startDateTime(LocalDateTime.of(2022, 7, 1, 9, 0))
                .endDateTime(LocalDateTime.of(2022, 7, 30, 18, 0))
                .basePrice(BigDecimal.valueOf(100))
                .maxPrice(BigDecimal.valueOf(200))
                .limitOfEnroll(10)
                .location("서울")
                .build();

        newLecture.setId(10L);
        Mockito.when(lectureRepository.save(newLecture)).thenReturn(newLecture);

        mockMvc.perform(post("/api/lectures")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(newLecture))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists());
    }

}