package com.example.jdk8_demo.async;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusinessServiceDemo {
    
    public List<Person> logic() {
        System.out.println("这个是执行逻辑的方法");
        List<Person> userList = new ArrayList<>(2);
        userList.add(Person.builder().name("张三").age(18).build());
        userList.add(Person.builder().name("李四").age(19).build());
        return userList;
    }
    
    
}

//
//class Person{
//
//
//
//}
