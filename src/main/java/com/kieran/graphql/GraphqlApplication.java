package com.kieran.graphql;

import com.kieran.graphql.entity.Author;
import com.kieran.graphql.entity.Book;
import com.kieran.graphql.repository.AuthorRepository;
import com.kieran.graphql.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			var author1 = new Author(null, "Kieran", "Mueller", "hfojnof", null);
			var author2 = new Author(null, "Belfry", "Mueller", "jioqwjfoiq", null);
			authorRepository.saveAll(List.of(author1, author2));
			bookRepository.saveAll(List.of(
				new Book(null, "Desperado", "NYT", author1),
				new Book(null, "Of Mice and Men", "Times co", author1),
				new Book(null, "Three Blind Mice", "Best Books co", author2)
			));
		};
	}
}
