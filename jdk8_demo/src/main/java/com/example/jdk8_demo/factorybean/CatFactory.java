package com.example.jdk8_demo.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Cat的初始化做一些定制化开发，容器启动在维护Cat 实例的时候会调用getObject方法，出发Cat 创建的额外操作， 可以配合
 */
public class CatFactory implements FactoryBean<Cat> {

    @Override
    public Cat getObject() throws Exception {
        return getCat();
    }

    /**
     * 获取cat 实例
     * @return
     */
    private Cat getCat() {

        Cat cat = new Cat();
        cat.setAge(18);
        cat.setName("tom");
        System.out.println("通过自定义工厂类实现对象实例获取");
        return cat;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
