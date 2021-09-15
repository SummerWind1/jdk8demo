package com.example.jdk8_demo.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionUtil {

    private static final Logger logger = LoggerFactory.getLogger(FunctionUtil.class);

    /**
     * 上锁方法
     * @param success
     * @param error
     * @param key
     */
    public static void lock(String key, MyFunctionInterface success, MyFunctionInterface error) {

        if (true) {
            success.execute(key);
        } else {
            error.execute(key);
        }
    }

    public static void main(String[] args) {

        DemoService demoService = new DemoService();

        demoService.demoMethod();

    }
}
