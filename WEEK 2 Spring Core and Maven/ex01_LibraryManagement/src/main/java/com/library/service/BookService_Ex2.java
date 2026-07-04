package com.library.service;

import com.library.repository.BookRepository_Ex2;

public class BookService_Ex2 {
    // Declaring the dependency reference
    private BookRepository_Ex2 bookRepository;

    // [Ex 2] The setter method Spring uses to inject the BookRepository dependency [cite: 24]
    public void setBookRepository(BookRepository_Ex2 bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("[Ex 2 Service] Passing work along to our dependency...");
        // This will throw a NullPointerException if dependency injection failed
        bookRepository.save();
    }
}