package com.example.spring_study.book.repository;

import com.example.spring_study.book.entity.BookEntity;

public interface BookRepository {

    public BookEntity save(BookEntity book);
}
