package com.example.jdk8_demo.completefuture;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory{

    AtomicInteger threadNumber = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread("pool-" + threadNumber.incrementAndGet());
    }
}
