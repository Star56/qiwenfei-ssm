package com.qiwenfei.note.countdownlatchandjoin;

import java.util.concurrent.CountDownLatch;

/**
 * 2019/1/11
 * sunshine
 */
public class CountDownLatchDemo  implements Runnable{

    private CountDownLatch cdl ;
    public CountDownLatchDemo(CountDownLatch countDownLatch) {
        this.cdl = countDownLatch ;
    }

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"完成初始化,开始访问数据库");
    }
}
