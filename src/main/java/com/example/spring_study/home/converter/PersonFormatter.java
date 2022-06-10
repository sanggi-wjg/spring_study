//package com.example.spring_study.home.formatter;
//
//import org.springframework.format.Formatter;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//public class PersonFormatter implements Formatter<Person> {
//
//    @Override
//    public Person parse(String text, Locale locale) throws ParseException {
//        Person person = new Person();
//        person.setName(text);
//        return person;
//    }
//
//    @Override
//    public String print(Person object, Locale locale) {
//        return null;
//    }
//
//}
