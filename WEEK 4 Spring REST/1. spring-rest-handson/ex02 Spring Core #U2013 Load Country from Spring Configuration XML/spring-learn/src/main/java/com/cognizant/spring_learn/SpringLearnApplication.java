package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");

        // Start the Spring Boot application
        SpringApplication.run(SpringLearnApplication.class, args);

        // Call method from Hands-on 2
        displayDate();

        LOGGER.info("END");
    }

    public static void displayDate() {
        LOGGER.info("START");

        // Load Spring XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

        // Get dateFormat bean
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date", e);
        }

        LOGGER.info("END");
    }
}
