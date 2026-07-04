package com.badcow.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.badcow")
@EnableJpaRepositories(basePackages = "com.badcow.repository")
@EntityScan(basePackages = "com.badcow.entity")
public class BadcowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadcowApplication.class, args);
    }
}