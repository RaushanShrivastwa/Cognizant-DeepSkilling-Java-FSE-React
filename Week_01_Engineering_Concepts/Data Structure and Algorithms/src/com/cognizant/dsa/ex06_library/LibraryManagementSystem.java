package com.cognizant.dsa.ex06_library;

import java.util.Arrays;

// ==========================================================
// 1. BOOK DATA MODEL
// ==========================================================
class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Required for sorting books alphabetically by title before Binary Search
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "ID: " + bookId + " | Title: \"" + title + "\" | Author: " + author;
    }
}

// ==========================================================
// 2. SEARCH ENGINE METHODS
// ==========================================================
class SearchEngine {

    // Linear Search Implementation - O(n) Time Complexity
    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book; // Match found
            }
        }
        return null; // Not found
    }

    // Binary Search Implementation - O(log n) Time Complexity
    public static Book binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return sortedBooks[mid]; // Match found at midpoint
            }
            if (comparison < 0) {
                left = mid + 1; // Look in the right half
            } else {
                right = mid - 1; // Look in the left half
            }
        }
        return null; // Not found
    }
}

// ==========================================================
// 3. MAIN TEST APPLICATION
// ==========================================================
public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Testing Exercise 6: Library Management System ===");

        // Create an unsorted array of books
        Book[] libraryCatalog = {
                new Book("B001", "The Alchemist", "Paulo Coelho"),
                new Book("B002", "Effective Java", "Joshua Bloch"),
                new Book("B003", "To Kill a Mockingbird", "Harper Lee"),
                new Book("B004", "Clean Code", "Robert C. Martin"),
                new Book("B005", "Design Patterns", "Gang of Four")
        };

        String targetBook = "Clean Code";

        // 1. Test Linear Search (Works on unsorted data)
        System.out.println("\n--- Triggering Linear Search ---");
        Book foundViaLinear = SearchEngine.linearSearchByTitle(libraryCatalog, targetBook);
        if (foundViaLinear != null) {
            System.out.println("SUCCESS (Linear): Found book -> " + foundViaLinear);
        } else {
            System.out.println("Book not found via Linear Search.");
        }

        // 2. Test Binary Search (Requires sorted data)
        System.out.println("\n--- Triggering Binary Search ---");
        System.out.println("Sorting catalog alphabetically by book title...");
        Arrays.sort(libraryCatalog); // Uses compareTo method logic internally

        System.out.println("Sorted Catalog Overview:");
        for (Book b : libraryCatalog) {
            System.out.println("  " + b);
        }

        Book foundViaBinary = SearchEngine.binarySearchByTitle(libraryCatalog, targetBook);
        if (foundViaBinary != null) {
            System.out.println("\nSUCCESS (Binary): Found book -> " + foundViaBinary);
        } else {
            System.out.println("\nBook not found via Binary Search.");
        }
    }
}