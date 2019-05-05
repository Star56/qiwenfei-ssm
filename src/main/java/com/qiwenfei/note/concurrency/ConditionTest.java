package com.qiwenfei.note.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2019/1/10
 * sunshine
 */
public class ConditionTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionDemoWait conditionDemoWait = new ConditionDemoWait(lock,condition);
        Thread thread1 = new Thread(conditionDemoWait,"condition-wait-1");
        Thread thread2 = new Thread(conditionDemoWait,"condition-wait-2");
        thread1.start();
        thread2.start();

        ConditionDemoSignal  conditionDemoSignal = new ConditionDemoSignal(lock,condition);
        new Thread(conditionDemoSignal,"condition-signal").start();
    }
}
