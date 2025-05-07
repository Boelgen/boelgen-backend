package com.boelgen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = "com.boelgen.app.model") 
public class AppApplication {

	public static void main(String[] args) {
        
         // Load the .env file
         Dotenv dotenv = Dotenv.configure()
        
         .filename("variables.env") // Specify the .env file name
         .load();

     // Set environment variables
     // Set environment variables with null checks
     String dbUsername = dotenv.get("MYSQL_USERNAME");
     if (dbUsername != null) {
         System.setProperty("MYSQL_USERNAME", dbUsername);
     }

     String dbPassword = dotenv.get("MYSQL_PASSWORD");
     if (dbPassword != null) {
         System.setProperty("MYSQL_PASSWORD", dbPassword);
     }

     String dbHostname = dotenv.get("MYSQL_HOSTNAME");
     if (dbHostname != null) {
         System.setProperty("MYSQL_HOSTNAME", dbHostname);
     }

     String dbName = dotenv.get("MYSQL_DATABASE");
     if (dbName != null) {
         System.setProperty("MYSQL_DATABASE", dbName);
     }
		SpringApplication.run(AppApplication.class, args);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        System.out.println("From dotenv - MYSQL_USERNAME: " + dotenv.get("MYSQL_USERNAME"));
        System.out.println("From dotenv - MYSQL_HOSTNAME: " + dotenv.get("MYSQL_HOSTNAME"));
        System.out.println("From dotenv - MYSQL_DATABASE: " + dotenv.get("MYSQL_DATABASE"));
        
	}

    
	@PostConstruct
	public void checkEnvironment() {
	    System.out.println("MYSQL_HOSTNAME: " + System.getProperty("MYSQL_HOSTNAME"));
	    System.out.println("MYSQL_DATABASE: " + System.getProperty("MYSQL_DATABASE"));
	}
        
}
