package com.qiwenfei.note.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 2019/1/10
 * sunshine
 */
public class ConditionDemoSignal implements Runnable{
    private Lock lock ;
    private Condition condition ;

    public ConditionDemoSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("---condition-signal开始通知---");
        try {
            lock.lock();
            condition.signal();
            System.out.println("---condition-signal通知完成---");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
