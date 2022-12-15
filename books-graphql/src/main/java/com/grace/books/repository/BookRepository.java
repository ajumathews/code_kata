package com.grace.books.repository;

import java.util.ArrayList;
import java.util.List;
import com.grace.books.model.Book;
import com.grace.books.model.Rating;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final AuthorRepository authorRepository;

    private List<Book> books = new ArrayList<>();

    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findOne(Integer id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostConstruct
    private void init() {
        books.add(new Book(1,
                "Reactive Spring",
                484,
                Rating.FIVE_STARS,
                authorRepository.findByName("Josh")));
        books.add(new Book(2,
                "Spring Boot Up & Running",
                328,
                Rating.FIVE_STARS,
                authorRepository.findByName("Mark")));
        books.add(new Book(3,
                "Hacking with Spring Boot 2.3",
                392,
                Rating.FIVE_STARS,
                authorRepository.findByName("Greg")));
    }

}
