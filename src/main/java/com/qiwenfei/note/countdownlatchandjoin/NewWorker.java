package com.qiwenfei.note.countdownlatchandjoin;

import java.util.concurrent.CountDownLatch;

/**
 * 2018-05-20
 * 场景描述：三个工人，work0、work1、work2；work0、work1 同时工作
 * 等work0、work1都完成第一阶段工作后，work2才开始工作
 * sunshine
 */
public class NewWorker extends  Thread{

    private  String name ;

    private long time ;

   private CountDownLatch cdl;

    public NewWorker(String name, long time, CountDownLatch cdl) {
        this.name = name;
        this.time = time;
        this.cdl = cdl;
    }

    @Override
    public void run() {


        try {
            System.out.println("工人"+this.name+"开始第一阶段工作");
            Thread.sleep(1000L);
            System.out.println("工人"+this.name+"完成第一阶段工作,耗时："+this.time+"ms");
            cdl.countDown();
            System.out.println("工人"+this.name+"开始第二阶段工作");
            Thread.sleep(2000L);
            System.out.println("工人"+this.name+"完成第二阶段工作,耗时："+this.time+"ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
