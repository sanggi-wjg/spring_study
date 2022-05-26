package com.example.spring_study.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSourceRunner implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=================================================================");
        System.out.println("[MessageSource]");
        System.out.println("Locale Default: " + Locale.getDefault());
        System.out.println("Greeting in Korean: " + messageSource.getMessage("greeting", new String[]{"User"}, Locale.KOREAN));
        System.out.println("Greeting in Korean: " + messageSource.getMessage("greeting", new String[]{"User"}, Locale.US));
        System.out.println("Greeting in default: " + messageSource.getMessage("greeting", new String[]{"User"}, Locale.getDefault()));
        System.out.println("=================================================================");
    }
}
