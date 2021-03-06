package com.example.spring_study.example.resource;

import com.example.spring_study.LocalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ResourceSourceRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    LocalProperties localProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=================================================================");
        System.out.println("[ResourceSource - Properties]");
        System.out.println(localProperties.getName());
        System.out.println(localProperties.getDesc());
        System.out.println(localProperties.getSessTimeOut());

        System.out.println("[ResourceSource - Text]");
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("resource exist: " + resource.exists());
        System.out.println("resource filename: " + resource.getFilename());
        System.out.println("resource description: " + resource.getDescription());
        System.out.println("resource file: " + resource.getFile());
        System.out.println("resource read: " + Files.readString(Path.of(resource.getURI())));
        System.out.println("=================================================================");
    }
}

