package com.example.spring_study.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    WebClient.Builder webClientBuilder; // async

    @Autowired
//    RestTemplateBuilder restTemplateBuilder; // sync

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        StopWatch stopWatch = new StopWatch();
//        System.out.println("[RestTemplateBuilder - Sync request] ");
//
//        RestTemplate build = restTemplateBuilder.build();
//        stopWatch.start();
//
//        String result1 = build.getForObject("http://localhost:9001/sleep-5", String.class);
//        String result2 = build.getForObject("http://localhost:9001/sleep-3", String.class);
//        stopWatch.stop();
//
//        System.out.println(stopWatch.prettyPrint());
        System.out.println("[WebClient - Sync request] ");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        /* 아니면 MainApplication에 Bean으로 등록 하면 baseurl 계속 사용할수도 있음
        @Bean
        public WebClientCustomizer webClientCustomizer() {
            return new WebClientCustomizer(){
                @Override
                public void customize(WebClient.Builder webClientBuilder) {
                    webClientBuilder.baseUrl("http://localhost:9001");
                }
            };
        }
        * */
        WebClient webClient = webClientBuilder
                .baseUrl("http://localhost:9001")
                .build();
        Mono<String> firstMono = webClient.get()
                .uri("/sleep-5")
                .retrieve()
                .bodyToMono(String.class);
        firstMono.subscribe(s -> {
            System.out.println(s);
            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }
            stopWatch.start();
        });

        Mono<String> secondMono = webClient.get()
                .uri("/sleep-3")
                .retrieve()
                .bodyToMono(String.class);
        secondMono.subscribe(s -> {
            System.out.println(s);
            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }
            stopWatch.start();
        });

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
