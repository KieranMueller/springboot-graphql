package com.kieran.graphql.service;

import com.kieran.graphql.entity.Book;
import com.kieran.graphql.input.BookInput;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book createBook(BookInput book);
}
