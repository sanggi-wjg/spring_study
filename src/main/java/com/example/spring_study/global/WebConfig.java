package com.example.spring_study.global;

import com.example.spring_study.home.interceptor.AnotherInterceptor;
import com.example.spring_study.home.interceptor.GreetingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /m/** 로 request 올시에 resource 를 /m/ 경로로 매핑
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/")
                .setCachePeriod(20);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // /hello request 시 CORS 매핑
        registry.addMapping("/hello")
                .allowedOrigins("http://localhost:9002");
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new PersonFormatter());
//        registry.addConverter();
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
         * [Interceptor 처리 순서]
         * preHandle 1
         * preHandle 2
         * 요청 처리
         * postHandle 2
         * postHandle 1
         * 뷰 렌더링
         * afterCompletion 2
         * afterCompletion 1
         *
         * [Order]
         * 작은 값일 수록 우선 순위
         * */
        registry.addInterceptor(new GreetingInterceptor())
                .order(-1);
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi")
                .order(0);

    }
}
