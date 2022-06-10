package com.example.spring_study.home;

import com.example.spring_study.home.converter.Person;
import com.example.spring_study.home.converter.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", is("Snow")));
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.__links.self").exists());
    }

    @Test
//    @WithMockUser(username = "test_user", password = "test_password", roles = {"USER", "ADMIN"})
    public void testHelloPerson() throws Exception {
        Person person = new Person();
        person.setName("jay");
        personRepository.save(person);

//        mockMvc.perform(get("/hello").param("id", person.getId().toString()))
//                .andDo(print())
//                .andExpect(status().isOk());
    }

}