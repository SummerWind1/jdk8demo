package com.example.jdk8_demo;

import com.example.jdk8_demo.factorybean.Cat;
import com.example.jdk8_demo.factorybean.CatFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example")
public class Jdk8DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Jdk8DemoApplication.class, args);

        Object cat = run.getBean("cat");

        System.out.println(cat.toString());
    }
    
    @Bean
    public CatFactory cat() {
        return new CatFactory();
    }

}
