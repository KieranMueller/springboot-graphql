package com.kieran.graphql.controller;

import com.kieran.graphql.entity.Author;
import com.kieran.graphql.input.AuthorInput;
import com.kieran.graphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public List<Author> authors() {
        return authorService.findAll();
    }

    @QueryMapping
    public Author authorById(@Argument Long id) {
        return authorService.findById(id);
    }

    @QueryMapping
    public List<Author> authorsByLastName(@Argument String lastName) {
        return authorService.getAuthorsByLastName(lastName);
    }

    @MutationMapping
    public Author createAuthor(@Argument AuthorInput author) {
        return authorService.createAuthor(author);
    }
}
