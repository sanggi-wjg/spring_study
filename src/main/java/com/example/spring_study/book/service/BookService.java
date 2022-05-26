package com.example.spring_study.book.service;

import com.example.spring_study.book.data.BookStatus;
import com.example.spring_study.book.entity.BookEntity;
import com.example.spring_study.book.repository.BookRepository;
import com.example.spring_study.book.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private List<BookRepository> bookRepositories;

    @Autowired
    private MyBookRepository myBookRepository;

    @PostConstruct
    public void printBookRepositories() {
        bookRepositories.forEach(System.out::println);
    }

    public BookEntity save(BookEntity book) {
        book.setCreatedDate(new Date());
        book.setBookStatus(BookStatus.DRAFT);
        return myBookRepository.save(book);
    }


}
