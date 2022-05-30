package com.example.spring_study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:/test.properties")
@SpringBootTest
class SpringStudyApplicationTests {

    @Autowired
    Environment environment;

    @Test
    void contextLoads() {
        assertEquals(environment.getProperty("app.name"), "Spring Study Test");
        System.out.println(environment.getProperty("app.desc"));
    }

}
