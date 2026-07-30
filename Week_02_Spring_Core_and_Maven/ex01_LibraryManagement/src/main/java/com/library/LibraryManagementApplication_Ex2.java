package com.library;

import com.library.service.BookService_Ex2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication_Ex2 {
    public static void main(String[] args) {
        // Load the Exercise 2 configuration context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_Ex2.xml");

        // Fetch the wired service bean instance
        BookService_Ex2 service = context.getBean("bookService", BookService_Ex2.class);

        // Execute to verify the injection layer works
        service.addBook();
    }
}