package com.kieran.graphql.service.impl;

import com.kieran.graphql.entity.Author;
import com.kieran.graphql.entity.Book;
import com.kieran.graphql.input.AuthorInput;
import com.kieran.graphql.repository.AuthorRepository;
import com.kieran.graphql.repository.BookRepository;
import com.kieran.graphql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Author> getAuthorsByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    @Override
    public Author createAuthor(AuthorInput author) {
        Author savedAuthor = authorRepository.save(new Author(null, author.getFirstName(),
                author.getLastName(), "jfoejwfo", null));
        for(var book : author.getBooks()) {
            Book bookEntity = new Book(null, book.getTitle(), book.getPublisher(),
                    savedAuthor);
            bookRepository.save(bookEntity);
        }
        return authorRepository.findById(savedAuthor.getId()).orElseThrow();
    }

    @Override
    public Author updateAuthor(AuthorInput author) {
        Author authorEnt = authorRepository.findById(author.getId()).orElseThrow();
        if(author.getFirstName() != null)
            authorEnt.setFirstName(author.getFirstName());
        if(author.getLastName() != null)
            authorEnt.setLastName(author.getLastName());
        if(author.getBooks() != null) {
            author.getBooks().forEach(book -> {
                authorEnt.getBooks().add(new Book(null, book.getTitle(), book.getPublisher(), authorEnt));
            });
        }
        return authorRepository.save(authorEnt);
    }

    @Override
    public Author deleteAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        authorRepository.deleteById(id);
        return author;
    }
}
