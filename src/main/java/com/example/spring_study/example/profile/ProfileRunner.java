package com.example.spring_study.example.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProfileRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Value("${app.name}")
    String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=================================================================");
        System.out.println("[Profile]");
        Environment environment = ctx.getEnvironment();
        System.out.println("ActiveProfile: " + Arrays.toString(environment.getActiveProfiles()));
        System.out.println("DefaultProfile: " + Arrays.toString(environment.getDefaultProfiles()));

        System.out.println("AppName: " + environment.getProperty("app.name"));
        System.out.println("AppName: " + appName);
        System.out.println("=================================================================");
    }
}
