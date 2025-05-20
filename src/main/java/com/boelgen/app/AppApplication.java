package com.boelgen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = "com.boelgen.app.model")
public class AppApplication {

    public static void main(String[] args) {
        // Set environment variables directly from system properties
        System.setProperty("MYSQL_USERNAME", System.getenv("MYSQL_USERNAME"));
        System.setProperty("MYSQL_PASSWORD", System.getenv("MYSQL_PASSWORD"));
        System.setProperty("MYSQL_HOSTNAME", System.getenv("MYSQL_HOSTNAME"));
        System.setProperty("MYSQL_DATABASE", System.getenv("MYSQL_DATABASE"));

        SpringApplication.run(AppApplication.class, args);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        System.out.println("From env - MYSQL_USERNAME: " + System.getenv("MYSQL_USERNAME"));
        System.out.println("From env - MYSQL_HOSTNAME: " + System.getenv("MYSQL_HOSTNAME"));
        System.out.println("From env - MYSQL_DATABASE: " + System.getenv("MYSQL_DATABASE"));
    }

    @PostConstruct
    public void checkEnvironment() {
        System.out.println("MYSQL_HOSTNAME: " + System.getProperty("MYSQL_HOSTNAME"));
        System.out.println("MYSQL_DATABASE: " + System.getProperty("MYSQL_DATABASE"));
    }
}
