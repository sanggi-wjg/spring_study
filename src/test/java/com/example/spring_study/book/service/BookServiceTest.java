package com.example.spring_study.book.service;

import com.example.spring_study.book.data.BookStatus;
import com.example.spring_study.book.entity.BookEntity;
import com.example.spring_study.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Test
    public void testSave() {
        // given
        BookEntity book = new BookEntity();

        // when
//        BookEntity newBook = bookService.save(book);

        // then
//        assertNotEquals(newBook.getCreatedDate(), null);
//        assertEquals(newBook.getBookStatus(), BookStatus.DRAFT);
    }

}