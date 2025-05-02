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
     // Set environment variables with null checks
     String dbUsername = dotenv.get("DB_USERNAME");
     if (dbUsername != null) {
         System.setProperty("DB_USERNAME", dbUsername);
     }

     String dbPassword = dotenv.get("DB_PASSWORD");
     if (dbPassword != null) {
         System.setProperty("DB_PASSWORD", dbPassword);
     }

     String dbHostname = dotenv.get("DB_HOSTNAME");
     if (dbHostname != null) {
         System.setProperty("DB_HOSTNAME", dbHostname);
     }

     String dbName = dotenv.get("DB_NAME");
     if (dbName != null) {
         System.setProperty("DB_NAME", dbName);
     }

     String dbSslCa = dotenv.get("DB_SSL_CA");
     if (dbSslCa != null) {
         System.setProperty("DB_SSL_CA", dbSslCa);
     }
		SpringApplication.run(AppApplication.class, args);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}
}
