package com.example.jdk8_demo.completefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * future 拓展
 */
public class CompleteFutureDemo {

    public static void main(String[] args) {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        // 异步结束 lambda 表达式
        completableFuture.whenComplete((s, throwable) -> System.out.println("2323"));
        //
//        completableFuture.whenCompleteAsync()
    }



}
