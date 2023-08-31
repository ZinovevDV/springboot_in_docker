package ru.mail.zinovev_dv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var ccontext = SpringApplication.run(Application.class, args);
    }
}
