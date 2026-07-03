package com.cognizant.dsa.ex01_inventory;

import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " | Qty: " + quantity + " | Price: $" + price;
    }
}

class Inventory {
    private Map<String, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
        System.out.println("[ADDED]: " + product.getProductName());
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("[UPDATED]: " + product.getProductName());
        } else {
            System.out.println("[ERROR]: Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        Product removed = productMap.remove(productId);
        if (removed != null) System.out.println("[DELETED]: " + removed.getProductName());
    }

    public void displayInventory() {
        System.out.println("\n--- Current Warehouse Inventory ---");
        for (Product p : productMap.values()) System.out.println(p);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Inventory System ===");
        Inventory warehouse = new Inventory();

        warehouse.addProduct(new Product("P101", "MacBook Pro M3", 50, 1999.99));
        warehouse.addProduct(new Product("P102", "iPhone 15 Pro", 120, 1099.99));

        warehouse.displayInventory();
        warehouse.updateProduct("P102", 115, 1049.99);
        warehouse.deleteProduct("P101");
        warehouse.displayInventory();
    }
}