package com.example.spring_study;

import com.example.spring_study.example.listener.SampleStartingListener;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

@PropertySource("classpath:/app.properties")
@EnableConfigurationProperties(LocalProperties.class)
@EnableAsync
@EnableAdminServer
@SpringBootApplication
public class SpringStudyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringStudyApplication.class);
        app.addListeners(new SampleStartingListener());
        app.run(args);
//        SpringApplication.run(SpringStudyApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/locale/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3);
        return messageSource;
    }

}
