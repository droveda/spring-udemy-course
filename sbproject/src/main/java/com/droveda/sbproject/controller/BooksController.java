package com.droveda.sbproject.controller;

import com.droveda.sbproject.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class BooksController {


    @GetMapping("/books")
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book(1, "Master Spring", "Ranga Kanaran", new Date()),
                new Book(2, "PGSQL 1.0", "Kiran Gunara", new Date())
        );
    }


}
