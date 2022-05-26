package com.example.spring_study.book.entity;

import com.example.spring_study.book.data.BookStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookEntity {

    private Date createdDate;
    private BookStatus bookStatus;


}
