package com.grace.books.controller;

import java.util.List;
import com.grace.books.model.Book;
import com.grace.books.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    @SchemaMapping(typeName = "Query", value = "findBookById")
    public Book findOne(@Argument Integer id){
        return bookRepository.findOne(id);
    }
}
