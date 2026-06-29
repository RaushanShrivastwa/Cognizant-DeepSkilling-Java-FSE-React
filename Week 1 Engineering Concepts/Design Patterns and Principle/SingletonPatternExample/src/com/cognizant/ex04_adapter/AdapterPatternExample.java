package com.cognizant.ex04_adapter;

interface PaymentProcessor {
    void processPayment(double amount);
}

class StripeGateway {
    public void makeStripePayment(double totalInUSD) {
        System.out.println("Processing payment of $" + totalInUSD + " securely through Stripe Gateway.");
    }
}

class PayPalGateway {
    public void sendPaymentViaPayPal(double amountInINR) {
        System.out.println("Processing payment of ₹" + amountInINR + " via PayPal Digital Wallet.");
    }
}
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makeStripePayment(amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Translate standard call to PayPal-specific call
        payPalGateway.sendPaymentViaPayPal(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Testing Exercise 4: Adapter Pattern ===");

        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        stripeProcessor.processPayment(150.50);

        System.out.println("----------------------------------------------");

        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);

        payPalProcessor.processPayment(12500.00);
    }
}