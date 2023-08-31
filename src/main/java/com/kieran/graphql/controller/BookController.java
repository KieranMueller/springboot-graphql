package com.kieran.graphql.controller;

import com.kieran.graphql.entity.Book;
import com.kieran.graphql.input.BookInput;
import com.kieran.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> books() {
        return bookService.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument BookInput book) {
        return bookService.createBook(book);
    }
}
