package com.enterprise.eventmanagementsystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cache.annotation.EnableCaching;

/**
 * This is the class that starts the Spring Boot application.
 * @author Ali Ibrahim, Benjamin Gomori, Kevin Zhu, and Son Bo
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class EventManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementSystemApplication.class, args);
    }

}
