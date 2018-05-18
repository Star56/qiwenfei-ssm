package com.qiwenfei.note.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 2018-05-17
 * sunshine
 */
public class SingleTreadSafeTest {

    public static void main(String[] args) {

        int num = 200;
        long start = System.currentTimeMillis();
        final CountDownLatch cdl = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LazySingletonSimple singleton = LazySingletonSimple.getInstance();
                   System.out.println(singleton);

                }
            }.start();
            cdl.countDown();
        }

    }
}
