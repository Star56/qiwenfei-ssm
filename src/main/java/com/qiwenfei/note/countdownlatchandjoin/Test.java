package com.qiwenfei.note.countdownlatchandjoin;

import java.util.concurrent.CountDownLatch;

/**
 * 2019/1/11
 * sunshine
 */
public class Test {
    private static  int num = 10 ;
    private static CountDownLatch cdl = new CountDownLatch(num);

    public static void main(String[] args) {

        for (int i = 0; i < num; i++) {
            new Thread(new CountDownLatchDemo(cdl)).start();
            cdl.countDown();
        }

    }
}
