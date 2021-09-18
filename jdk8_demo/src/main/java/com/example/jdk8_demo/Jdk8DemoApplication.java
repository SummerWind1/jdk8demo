package com.example.jdk8_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example")
public class Jdk8DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Jdk8DemoApplication.class, args);
    }

}
