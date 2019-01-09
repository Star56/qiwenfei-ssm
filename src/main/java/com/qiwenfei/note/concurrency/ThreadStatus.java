package com.qiwenfei.note.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 2018/12/19
 * sunshine
 */
public class ThreadStatus {

    public static void main(String[] args) {

        new Thread(()->{
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"TIME_WAITING").start();
        /** 使用wait()必须获得锁**/
        new Thread(()->{
            while(true) {
                synchronized (ThreadStatus.class) {
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"WAITING").start();
        /** 两个线程争抢锁，会出现阻塞状态**/
        new Thread(new BlockedDemo(),"Blocked-1").start();
        new Thread(new BlockedDemo(),"Blocked-2").start();
    }

    static  class BlockedDemo extends Thread{
        @Override
        public void run() {
            while(true) {
                synchronized (BlockedDemo.class) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
