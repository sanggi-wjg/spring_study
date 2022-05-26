package com.example.spring_study.book.repository;

import com.example.spring_study.book.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MyBookRepository implements BookRepository{

    public BookEntity save(BookEntity book) {
        return book;
    }
}
