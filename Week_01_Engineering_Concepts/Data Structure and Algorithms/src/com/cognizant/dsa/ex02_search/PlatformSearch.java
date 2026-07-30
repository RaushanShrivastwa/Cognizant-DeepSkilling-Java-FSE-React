package com.cognizant.dsa.ex02_search;

import java.util.Arrays;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() { return productName; }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " (" + category + ")";
    }
}

class SearchEngine {
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) return i;
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comp = products[mid].getProductName().compareToIgnoreCase(targetName);
            if (comp == 0) return mid;
            if (comp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

public class PlatformSearch {
    public static void main(String[] args) {
        System.out.println("=== Exercise 2: Platform Search ===");
        Product[] catalog = {
                new Product("E101", "Wireless Mouse", "Electronics"),
                new Product("E102", "Mechanical Keyboard", "Electronics"),
                new Product("E103", "Gaming Monitor", "Electronics")
        };

        System.out.println("Linear Search Result Index: " + SearchEngine.linearSearch(catalog, "Gaming Monitor"));

        Arrays.sort(catalog);
        System.out.println("Binary Search Result Index: " + SearchEngine.binarySearch(catalog, "Gaming Monitor"));
    }
}