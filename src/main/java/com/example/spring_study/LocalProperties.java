package com.example.spring_study;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Component
@ConfigurationProperties("app")
public class LocalProperties {

    private String name;
    private String desc;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessTimeOut = Duration.ofMinutes(30);


}
