package com.example.jdk8_demo.function;

@FunctionalInterface
public interface MyFunctionInterface {

    /**
     * 上锁方法
     * @param key
     */
    public void execute(String key);

}
