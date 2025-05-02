package com.boelgen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
         // Load the .env file
         Dotenv dotenv = Dotenv.configure()
         .filename("variables.env") // Specify the .env file name
         .load();

     // Set environment variables
     System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
     System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
     System.setProperty("DB_HOSTNAME", dotenv.get("DB_HOSTNAME"));
     System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
     System.setProperty("DB_SSL_CA", dotenv.get("DB_SSL_CA"));
		SpringApplication.run(AppApplication.class, args);
	}
}
