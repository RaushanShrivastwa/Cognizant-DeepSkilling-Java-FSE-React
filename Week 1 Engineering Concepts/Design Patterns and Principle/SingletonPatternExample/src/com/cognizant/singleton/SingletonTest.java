package com.cognizant.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern ===");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a log message from logger1.");
        logger2.log("This is a log message from logger2.");

        System.out.println("\n--- Verification ---");
        System.out.println("Logger 1 Hashcode: " + logger1.hashCode());
        System.out.println("Logger 2 Hashcode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables refer to the identical instance. Singleton pattern verified!");
        } else {
            System.out.println("FAILURE: Multiple instances exist.");
        }
    }
}