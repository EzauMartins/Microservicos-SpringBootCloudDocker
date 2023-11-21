package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @GetMapping("/{id}/{currency}")
    private Book getBook(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency){

        var book = repository.getReferenceById(id);
        if (book == null) throw new RuntimeException("Book not Found");

        var port = environment.getProperty("local.server.port");

        book.setEnviroment(port);
        book.setCurrency(currency);


        return book;
    }

}
