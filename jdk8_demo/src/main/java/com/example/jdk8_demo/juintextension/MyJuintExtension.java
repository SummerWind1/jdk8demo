package com.example.jdk8_demo.juintextension;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

/**
 * @author panfang
 * @date 2021/9/26 15:07
 *
 * junit 拓展
 */
public class MyJuintExtension extends BlockJUnit4ClassRunner {

    public MyJuintExtension(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    protected MyJuintExtension(TestClass testClass) throws InitializationError {
        super(testClass);
    }
}
