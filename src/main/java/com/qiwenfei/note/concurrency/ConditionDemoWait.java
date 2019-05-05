package com.qiwenfei.note.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2019/1/9
 * sunshine
 */
public class ConditionDemoWait implements Runnable {
    private Lock lock ;
    private Condition  condition ;
    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        try {
            System.out.println("线程："+Thread.currentThread().getName()+"----condition-wait开始---");
            lock.lock();
            condition.await();//阻塞当前队列
            System.out.println("线程："+Thread.currentThread().getName()+"-----condition-wait结束-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition  condition = lock.newCondition();
        /* ConditionDemoWait conditionDemoWait = new ConditionDemoWait(lock,lock.newCondition());
        new Thread(conditionDemoWait).start();*/
        for (int i = 0; i <3 ; i++) {
            Thread thread = new Thread(()->{
                lock.lock();
                try {
                    System.out.println("-----开始-----");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }

    }
}
