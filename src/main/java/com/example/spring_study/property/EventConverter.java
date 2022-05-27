package com.example.spring_study.property;


import org.springframework.core.convert.converter.Converter;

public class EventConverter {

    public static  class StringToEventConverter implements Converter<String, Something> {
        @Override
        public Something convert(String source) {
            return null;
        }

        @Override
        public <U> Converter<String, U> andThen(Converter<? super Something, ? extends U> after) {
            return Converter.super.andThen(after);
        }
    };
}
