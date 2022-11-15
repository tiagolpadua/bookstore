package com.example.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.models.Book;
import com.example.bookstore.repositories.BookRepository;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    List<Book> all() {
        return bookRepository.findAll();
    }

    @PostMapping
    Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @GetMapping("/{id}")
    Book one(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + ""));
    }

    @PutMapping("/{id}")
    Book replaceEmployee(@RequestBody Book newBook, @PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Not found!"));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
