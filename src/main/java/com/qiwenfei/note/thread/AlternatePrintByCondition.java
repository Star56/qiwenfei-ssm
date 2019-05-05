package com.qiwenfei.note.thread;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2019/1/15
 * sunshine
 * 使用Lock与Condition实现两个线程交替打印
 */
public class AlternatePrintByCondition {
   static  LinkedBlockingQueue<Integer> integers =  new LinkedBlockingQueue<Integer>() ;
   static ReentrantLock  lock = new ReentrantLock();
   static Condition  condition = lock.newCondition();
   static   int i =1 ;

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while(i<101) {
                lock.lock();
                while (integers.size() > 0) {//队列已有数据
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                integers.add(-i);
                i++;
                condition.signal();
                lock.unlock();
            }
        },"print>0");

        Thread thread2 = new Thread(() -> {
            while(i<101) {
                lock.lock();
                while (integers.size() < 1) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println(integers.take());
                    condition.signal();
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"print<0");
            thread.start();
            thread2.start();


    }
}
