package com.example.jdk8_demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 异步注解使用
 */
@EnableAsync
@Configuration
public class AsyncDemo {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 6, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024));

    @Autowired
    private BusinessServiceDemo businessServiceDemo;

    @Async("taskExecutor1")
    public CompletableFuture<List<String>> asyncMethodDemo1() throws InterruptedException {
//        Thread.sleep(5000);
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
    public CompletableFuture<List<Person>> asyncMethodDemo2() throws InterruptedException {
//        Thread.sleep(5000);

        System.out.println("异步方法执行,当前线程名称：" + Thread.currentThread().getName());

        List<Person> logic = businessServiceDemo.logic();

        return CompletableFuture.completedFuture(logic);
    }

    @Async("taskExecutor1")
    public void normalPool() {
        System.out.println("异步方法执行,当前线程名称：" + Thread.currentThread().getName());
        System.out.println("普通的异步方法");
    }

    /**
     * 普通的线程池
     * @param runnable
     */
    public void testThreadPoolExecutor(Runnable runnable) throws InterruptedException {
//        Thread.sleep(10000);
        executor.execute(runnable);
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
