package com.qiwenfei.note.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 2018/11/9
 * sunshine
 * FutureTask 可以启动一个子线程去执行call方法，进行耗时计算
 * 主线程可以同步计算不必阻塞等待
 * 当计算完后调用future 时call方法一执行完毕，返回执行结果
 *当call中方法较耗时时使用Callable Future
 */
public class MyCallable {
    public static void main(String[] args) {
        Callable<Integer>  callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("子线程开始执行");
                int i = 0 ;i++ ;System.out.println("子线程执行完成");
                return  i;
            }
        };
        FutureTask<Integer>  futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("---主线程执行---");
            TimeUnit.SECONDS.sleep(5);
            Integer integer =  futureTask.get();
            System.out.println(integer);
        } catch (Exception e){
          e.printStackTrace();
        }
    }
}
