package com.example.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
