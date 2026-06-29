package com.cognizant.ex05_decorator;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS (Text Message): " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack Notification: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Testing Exercise 5: Decorator Pattern ===");

        Notifier notifyStack = new EmailNotifier();

        notifyStack = new SMSNotifierDecorator(notifyStack);

        notifyStack = new SlackNotifierDecorator(notifyStack);

        System.out.println("Triggering alert pipeline...");
        notifyStack.send("System maintenance scheduled at 11:00 PM.");
    }
}