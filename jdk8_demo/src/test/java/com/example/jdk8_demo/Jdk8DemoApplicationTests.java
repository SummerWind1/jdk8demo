package com.example.jdk8_demo;

import com.example.jdk8_demo.async.AsyncDemo;
import com.example.jdk8_demo.async.Person;
import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootTest
@VisibleForTesting
class Jdk8DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AsyncDemo asyncDemo;

    @Test
    public void testAsync() throws InterruptedException, ExecutionException {

        System.out.println("当前线程开始执行");
        // 第一个任务
        CompletableFuture<List<String>> listCompletableFuture = executeWith1();
        // 第二个任务
        CompletableFuture<List<Person>> listCompletableFuture1 = executeWith2();
        CompletableFuture<List<Person>> listCompletableFuture2 = executeWith2();
        CompletableFuture<List<Person>> listCompletableFuture3 = executeWith2();

        CompletableFuture.allOf(listCompletableFuture, listCompletableFuture1, listCompletableFuture2, listCompletableFuture3).join();

        Thread.sleep(10000);
        System.out.println("测试方法执行结束");
    }


    public CompletableFuture<List<String>> executeWith1() throws InterruptedException, ExecutionException {
        CompletableFuture<List<String>> listCompletableFuture = asyncDemo.syncMethodDemo1();

        List<String> strings = listCompletableFuture.get();

        System.out.println(strings);

        return listCompletableFuture;
    }

    public CompletableFuture<List<Person>> executeWith2() throws InterruptedException, ExecutionException {
        CompletableFuture<List<Person>> listCompletableFuture = asyncDemo.syncMethodDemo2();
        System.out.println(listCompletableFuture.get());
        return listCompletableFuture;
    }

}
