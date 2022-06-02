package com.example.spring_study.home;

import com.example.spring_study.global.exception.SampleError;
import com.example.spring_study.global.exception.SampleException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/sample-e")
    public String hello() {
        throw new SampleException();
    }


    @ExceptionHandler(SampleException.class)
    public SampleError sampleError() {
        SampleError sampleError = new SampleError();
        sampleError.setMessage("sample.error occurred");
        sampleError.setReason("I don't know");
        return sampleError;
    }

}
