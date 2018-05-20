package com.qiwenfei.note.countdownlatchandjoin;

/**
 * 2018-05-18
 * 场景描述：三个工人，work0、work1、work2；work0、work1 同时工作
 * 等work0、work1都完成后，work2才开始工作
 * sunshine
 */
public class JoinTest {

    public static void main(String[] args) {

        Worker  worker0 = new Worker("work0",1000L);
        Worker  worker1 = new Worker("work1",1000L);
        Worker  worker2 = new Worker("work2",1000L);

        worker0.start();
        worker1.start();

        try {
            worker0.join();
            worker1.join();
            worker2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
