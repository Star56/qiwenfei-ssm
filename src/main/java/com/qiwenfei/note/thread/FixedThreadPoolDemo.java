package com.qiwenfei.note.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 2019/1/14
 * sunshine
 */
public class FixedThreadPoolDemo implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完成");
    }

    public static void main(String[] args) {
        ExecutorService service =  Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            service.submit(new FixedThreadPoolDemo());
        }
        service.shutdown();
    }
}
