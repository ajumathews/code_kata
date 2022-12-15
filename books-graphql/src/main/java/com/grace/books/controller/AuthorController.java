package com.grace.books.controller;

import java.util.List;
import com.grace.books.model.Author;
import com.grace.books.model.Book;
import com.grace.books.repository.AuthorRepository;
import com.grace.books.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @SchemaMapping(typeName = "Query", value = "allAuthors")
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", value = "findAuthorById")
    public Author findOne(@Argument Integer id){
        return authorRepository.findOne(id);
    }
}
