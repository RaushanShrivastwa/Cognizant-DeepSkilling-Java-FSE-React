package com.cognizant.singleton;

public class Logger {


    private Logger() {
        if (LoggerHolder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created.");
        }
    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}