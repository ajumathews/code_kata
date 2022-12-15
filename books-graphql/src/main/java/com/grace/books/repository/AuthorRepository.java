package com.grace.books.repository;

import java.util.ArrayList;
import java.util.List;
import com.grace.books.model.Author;
import com.grace.books.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public Author findOne(Integer id) {
        return authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(int id) {
        return authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByName(String name) {
        return authors.stream()
                .filter(author -> author.getFirstName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostConstruct
    private void init() {
        authors.add(new Author(1,"Josh","Long"));
        authors.add(new Author(2,"Mark","Heckler"));
        authors.add(new Author(3,"Greg","Turnquist"));
    }
}
