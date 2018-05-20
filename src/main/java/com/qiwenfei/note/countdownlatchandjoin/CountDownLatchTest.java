package com.qiwenfei.note.countdownlatchandjoin;

import java.util.concurrent.CountDownLatch;

/**
 * 2018-05-20
 * sunshine
 */
public class CountDownLatchTest {

    private static CountDownLatch cdl ;

    public static void main(String[] args) {

        cdl = new CountDownLatch(2);

        NewWorker worker1 = new NewWorker("work1",1000L,cdl);
        NewWorker worker2 = new NewWorker("work2",1000L,cdl);
        NewWorker worker3 = new NewWorker("work3",1000L,cdl);

        worker1.start();
        worker2.start();
        try {
            cdl.await();
        }catch (Exception e){
           e.printStackTrace();
        }
        worker3.start();

    }
}
