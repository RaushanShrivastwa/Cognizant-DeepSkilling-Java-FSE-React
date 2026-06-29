package com.cognizant.ex06_proxy;

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println(">>> Network Call: Downloading '" + fileName + "' from remote cloud storage...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Rendering and Displaying image: " + fileName);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        } else {
            System.out.println("[CACHE HIT]: Reusing previously downloaded instance.");
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Testing Exercise 6: Proxy Pattern ===");

        Image image = new ProxyImage("high_res_architecture_diagram.png");

        System.out.println("\n--- First Render Command ---");
        image.display();

        System.out.println("\n--- Second Render Command ---");
        image.display();
    }
}