package com.example.jdk8_demo.async;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String name;

    private Integer age;

}
