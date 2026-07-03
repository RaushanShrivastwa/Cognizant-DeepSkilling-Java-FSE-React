package com.cognizant.dsa.ex03_sorting;

// ==========================================================
// 1. ORDER DATA MODEL
// ==========================================================
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return "ID: " + orderId + " | Customer: " + customerName + " | Total: $" + totalPrice;
    }
}

// ==========================================================
// 2. SORTING ENGINE (Bubble Sort vs Quick Sort)
// ==========================================================
class SortingEngine {

    // Bubble Sort implementation - O(n^2)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap elements
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort implementation entrypoint - O(n log n)
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);  // Sort left partition
            quickSort(orders, pivotIndex + 1, high); // Sort right partition
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i+1] and pivot element (orders[high])
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}

// ==========================================================
// 3. TEST RUNNER
// ==========================================================
public class OrderSorting {
    public static void main(String[] args) {
        System.out.println("=== Exercise 3: Sorting Customer Orders ===");

        // Dataset A for Bubble Sort testing
        Order[] batchA = {
                new Order("O001", "Alice", 250.50),
                new Order("O002", "Bob", 89.99),
                new Order("O003", "Charlie", 1200.00),
                new Order("O004", "David", 450.00)
        };

        // Dataset B for Quick Sort testing
        Order[] batchB = batchA.clone();

        System.out.println("\n--- Testing Bubble Sort ---");
        SortingEngine.bubbleSort(batchA);
        for (Order o : batchA) System.out.println(o);

        System.out.println("\n--- Testing Quick Sort ---");
        SortingEngine.quickSort(batchB, 0, batchB.length - 1);
        for (Order o : batchB) System.out.println(o);
    }
}