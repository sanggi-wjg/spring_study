package com.example.spring_study.home;

import com.example.spring_study.home.converter.Person;
import lombok.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

    @GetMapping("/sleep-5")
    public String sleep_5() throws InterruptedException {
        Thread.sleep(5000);
        return "sleep 5 - func() done!";
    }

    @GetMapping("/sleep-3")
    public String sleep_3() throws InterruptedException {
        Thread.sleep(3000);
        return "sleep 3 - func() done!";
    }


    @GetMapping("/message/string")
    public String stringMessage(@RequestBody String body) {
        return body;
    }

    @GetMapping("/message/json")
    public Person jsonMessage(@RequestBody Person person) {
        return person;
    }

    /*
     * [Request Header]
     *
     * 특정 헤더가 있는 요청
     * headers = HttpHeaders.ACCEPT
     *
     * 헤더가 없는 요청
     * headers = "!" + HttpHeaders.ACCEPT
     *
     * 키값이 있는 요청
     * headers = HttpHeaders.AUTHORIZATION + "=" + "value"
     *
     * 특정 헤더 값이 일치하는지
     * params = "MY-TOKEN=123"
     * */
    @GetMapping(value = "/header/example", headers = HttpHeaders.AUTHORIZATION)
    public String headerExample() {
        return "success";
    }


}
