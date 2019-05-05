package com.qiwenfei.note.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2019/1/15
 * sunshine
 * 使用wait与notify实现两个线程交替打印
 */
public class AlternatePrintByWait {
    static LinkedBlockingQueue<Integer> integers =  new LinkedBlockingQueue<Integer>() ;

    public static void main(String[] args) {
        DataPrint  printByWait = new DataPrint();
        new Thread(() ->{
            for (int i = 1; i <101 ; i++) {
                try {
                    printByWait.printZS(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"ZS").start();

        new Thread(()->{
            for (int i = 1; i < 101; i++) {
                try {
                    printByWait.printFS();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"负数").start();
    }
    
    
    static class DataPrint{

        public synchronized void printZS(int i) throws InterruptedException {
            while (integers.size()>0){
                this.wait();
            }
            System.out.println(i);
            integers.add(-i);
            this.notify();
        }

        public synchronized void printFS() throws InterruptedException {
            while (integers.size()<1){
                this.wait();
            }
            System.out.println(integers.take());

            this.notify();
        }

    }

}
