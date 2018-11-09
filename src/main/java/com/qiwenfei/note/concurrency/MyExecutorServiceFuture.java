package com.qiwenfei.note.concurrency;

import java.util.concurrent.*;

/**
 * 2018/11/9
 * sunshine
 * ExecutorService继承自Executor，它的目的是为我们管理Thread对象，从而简化并发编程;
 * Executor使我们无需显示的去管理线程的生命周期，是JDK 5之后启动任务的首选方式。
 * FutureTask实现了Future接口
 */
public class MyExecutorServiceFuture {
    public static void main(String[] args) {
        Callable<String> callable  = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("callable子线程开始执行");
                return "callable future";
            }
        };
        ExecutorService   executorService = Executors.newFixedThreadPool(1);
        Future<String> future  =  executorService.submit(callable);
        System.out.println("主线程在执行");
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(future.get()) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
