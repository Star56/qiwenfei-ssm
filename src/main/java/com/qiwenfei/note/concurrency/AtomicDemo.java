package com.qiwenfei.note.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2018/12/26
 * sunshine
 */
public class AtomicDemo {
    private static int count=0;
    static Lock lock=new ReentrantLock(true);
    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();   }
         count++;
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                AtomicDemo.inc();
            }).start();
        }
        Thread.sleep(3000);
        System.out.println("result:"+count);
    }

}
