package com.library;

import com.library.service.BookService_Ex1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// [Ex 1] Main testing runner class
public class LibraryManagementApplication_Ex1 {
    public static void main(String[] args) {
        // Load the context XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_Ex1.xml");

        // Fetch the service bean instance from IoC container
        BookService_Ex1 service = context.getBean("bookService", BookService_Ex1.class);

        // Execute test run
        service.executeService();
    }
}