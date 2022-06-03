package com.example.spring_study.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleepController {

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

}
