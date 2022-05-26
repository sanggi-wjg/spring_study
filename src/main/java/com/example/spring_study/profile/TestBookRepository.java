package com.example.spring_study.profile;

import com.example.spring_study.book.entity.BookEntity;
import com.example.spring_study.book.repository.BookRepository;

public class TestBookRepository implements BookRepository {


    @Override
    public BookEntity save(BookEntity book) {
        return null;
    }
}
