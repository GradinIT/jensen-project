package se.jensen.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRestServiceApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TestRestServiceApplication.class);
        app.run(args);
    }
}
