package com.example.jdk8_demo.postconstruct;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;

@Component
public class PostConstructDemo {

    @PostConstruct
    public void init() {

        System.out.println("PostConstructDemo init");

    }

    public static void main(String[] args) {

        int i =  924663930 % 100;
        System.out.println(i);

        DecimalFormat decimalFormat = new DecimalFormat("00");

        System.out.println(decimalFormat.format(i));

    }


}
