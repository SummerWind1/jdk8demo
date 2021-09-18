package com.example.jdk8_demo.completefuture;

import java.util.concurrent.*;

/**
 * future 拓展
 */
public class CompleteFutureDemo {

    /**
     * 线程池
     */
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 6, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024));

    // runnable callabel future FutureTask CompletableFuture 实现原理


    public static void main(String[] args) {

//        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        // 异步结束 lambda 表达式
//        completableFuture.whenComplete((s, throwable) -> System.out.println("2323"));
        FutureTask<String> firstFutureTask = new FutureTask<String>(() -> {
            Thread.sleep(1000);
            return "第一次执行成功";
        });
//        executor.execute(firstFutureTask);

        executor.submit(firstFutureTask);

        FutureTask<String> secondFutureTask = new FutureTask<String>(() -> {
            Thread.sleep(500);
            return "第二次次执行成功";
        });
//        executor.execute(secondFutureTask);
        executor.submit(secondFutureTask);

        System.out.println(executor.getQueue().isEmpty());
        FutureTask<String> thirdFutureTask = new FutureTask<String>(() -> {
            Thread.sleep(500);
            return "第三次执行成功";
        });
//        executor.execute(secondFutureTask);
        executor.submit(thirdFutureTask);

        System.out.println(executor.getQueue().isEmpty());

        try {
            System.out.println(secondFutureTask.get());
            System.out.println(firstFutureTask.get());
            System.out.println(thirdFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("任务执行结束");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        executor.shutdownNow();

    }





}
