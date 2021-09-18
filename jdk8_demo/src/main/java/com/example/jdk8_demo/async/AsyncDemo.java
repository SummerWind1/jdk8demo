package com.example.jdk8_demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步注解使用
 */
@EnableAsync
@Configuration
public class AsyncDemo {

    @Autowired
    private BusinessServiceDemo businessServiceDemo;

    @Async("taskExecutor1")
    public CompletableFuture<List<String>> syncMethodDemo1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("异步方法执行,当前线程名称：" + Thread.currentThread().getName());

        // 业务方法
        List<String> list = new ArrayList<>(4);
        list.add("233");
        list.add("233");
        list.add("233");
        list.add("233");
        return CompletableFuture.completedFuture(list);
    }

    @Async("taskExecutor2")
    public CompletableFuture<List<Person>> syncMethodDemo2() throws InterruptedException {
        Thread.sleep(5000);

        System.out.println("异步方法执行,当前线程名称：" + Thread.currentThread().getName());

        List<Person> logic = businessServiceDemo.logic();

        return CompletableFuture.completedFuture(logic);
    }

    @Bean(name = "taskExecutor1")
    public Executor taskExecutor1() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(2);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setQueueCapacity(128);
        taskExecutor.setThreadNamePrefix("executor-1-");
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadGroupName("2333");
        // 拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return taskExecutor;
    }

    @Bean(name = "taskExecutor2")
    public Executor taskExecutor2() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(2);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setQueueCapacity(128);
        taskExecutor.setThreadNamePrefix("executor-2-");
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadGroupName("2333");
        // 拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return taskExecutor;
    }

}
