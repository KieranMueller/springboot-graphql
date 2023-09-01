package com.kieran.graphql.service;

import com.kieran.graphql.entity.Author;
import com.kieran.graphql.input.AuthorInput;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById(Long id);

    List<Author> getAuthorsByLastName(String lastName);

    Author createAuthor(AuthorInput author);

    Author deleteAuthorById(Long id);

    Author updateAuthor(AuthorInput author);
}
