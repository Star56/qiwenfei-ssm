package com.qiwenfei.note.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 2018/12/19
 * sunshine
 */
public class InterruptDemo {
    private static int i ;

    public static void main(String[] args) throws InterruptedException {
         Thread  thread = new Thread(()->{
             while(true){
                 boolean isInterrupt = Thread.currentThread().isInterrupted();
                 if(isInterrupt){
                     System.out.println("中断标识复位前："+isInterrupt);
                     Thread.interrupted();
                     System.out.println("复位后："+ Thread.currentThread().isInterrupted());
                 }
             }
         },"InterruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

    }
}
