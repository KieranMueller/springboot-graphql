package com.kieran.graphql.input;

import lombok.Data;

// This class is used as an input when creating an author and passing a list of books
// that belong to that author. This is to avoid having to pass the author ID for each
// book in the request, I just set the author within the service layer
@Data
public class BookForAuthor {

    private String title;
    private String publisher;
}
