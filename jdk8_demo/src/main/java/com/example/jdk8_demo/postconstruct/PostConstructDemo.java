package com.example.jdk8_demo.postconstruct;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostConstructDemo {

    @PostConstruct
    public void init() {

        System.out.println("PostConstructDemo init");

    }


}
