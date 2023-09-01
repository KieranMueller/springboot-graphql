package com.kieran.graphql.input;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorInput {

    private Long id;
    private String firstName;
    private String lastName;
    private List<BookForAuthor> books = new ArrayList<>();
}
