package com.apnaadmi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.apnaadmi.app")
public class ApnaAadmiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApnaAadmiApplication.class, args);
    }
}
