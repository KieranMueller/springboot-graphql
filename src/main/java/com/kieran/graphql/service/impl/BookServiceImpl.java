package com.kieran.graphql.service.impl;

import com.kieran.graphql.entity.Author;
import com.kieran.graphql.entity.Book;
import com.kieran.graphql.input.BookInput;
import com.kieran.graphql.repository.AuthorRepository;
import com.kieran.graphql.repository.BookRepository;
import com.kieran.graphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(BookInput book) {
        Author author = authorRepository.findById(book.getAuthorId()).orElseThrow();
        return bookRepository.save(new Book(null, book.getTitle(), book.getPublisher(), author));
    }
}
