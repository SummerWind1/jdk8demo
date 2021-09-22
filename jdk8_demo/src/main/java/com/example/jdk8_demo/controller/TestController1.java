package com.example.jdk8_demo.controller;

import com.example.jdk8_demo.async.AsyncDemo;
import com.example.jdk8_demo.async.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class TestController1 {

    @Autowired
    private AsyncDemo asyncDemo;

    @GetMapping(value = "async")
    public void testAsync() throws InterruptedException, ExecutionException {

        System.out.println("当前线程开始执行");
        // 第一个任务，有返回结果
        CompletableFuture<List<String>> listCompletableFuture = executeWith1();
        // 第二个任务，有返回结果
        CompletableFuture<List<Person>> listCompletableFuture1 = executeWith2();
        CompletableFuture<List<Person>> listCompletableFuture2 = executeWith2();
        CompletableFuture<List<Person>> listCompletableFuture3 = executeWith2();

        // 普通异步执行，没有返回结果
        asyncDemo.normalPool();
        // 等待三个任务全部结束
        CompletableFuture.allOf(listCompletableFuture, listCompletableFuture1, listCompletableFuture2, listCompletableFuture3).join();
        // 打印一下三个任务是否全部结束
        System.out.println(listCompletableFuture1.isDone());
        System.out.println(listCompletableFuture2.isDone());
        System.out.println(listCompletableFuture3.isDone());

        // 简单线程池实现
        asyncDemo.testThreadPoolExecutor(() -> {
            System.out.println("线程池的使用");
        });

        System.out.println("测试方法执行结束");

    }

    public CompletableFuture<List<String>> executeWith1() throws InterruptedException, ExecutionException {
        CompletableFuture<List<String>> listCompletableFuture = asyncDemo.asyncMethodDemo1();

//        List<String> strings = listCompletableFuture.get();

//        System.out.println(strings);
        return listCompletableFuture;
    }

    public CompletableFuture<List<Person>> executeWith2() throws InterruptedException, ExecutionException {
        CompletableFuture<List<Person>> listCompletableFuture = asyncDemo.asyncMethodDemo2();
//        System.out.println(listCompletableFuture.get());
        return listCompletableFuture;
    }

}
