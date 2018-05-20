package com.qiwenfei.note.countdownlatchandjoin;

/**
 * 2018-05-18
 * 场景描述：三个工人，work0、work1、work2；work0、work1 同时工作
 * 等work0、work1都完成后，work2才开始工作
 * sunshine
 */
public class Worker extends Thread{

    private String name ;

    private long time ;

    public Worker(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println("工人："+this.name+"开始工作");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人"+this.name+"完成工作,耗时："+this.time+"ms");
    }
}
