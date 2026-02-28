package com.apnaadmi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        exclude = {
                org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
                org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
                org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration.class
        }
)
public class ApnaAadmiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApnaAadmiApplication.class, args);
    }
}