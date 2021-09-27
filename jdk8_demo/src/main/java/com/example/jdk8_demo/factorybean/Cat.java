package com.example.jdk8_demo.factorybean;

import lombok.Data;
import lombok.ToString;

/**
 * @author panfang
 */
@Data
@ToString
public class Cat {

    private String name;

    private Integer age;

    public static void main(String[] args) {

        System.out.println(1861526906 & 15);

        // 1111 & 1
        System.out.println(15 & 0x1);
        System.out.println(0x2);
        System.out.println(0x3);
        System.out.println(0x4);
        System.out.println(0x5);


    }

}
