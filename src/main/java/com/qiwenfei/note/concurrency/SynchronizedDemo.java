package com.qiwenfei.note.concurrency;

/**
 * 2018/12/25
 * sunshine
 */
public class SynchronizedDemo {

    private  static int  count =0 ;

    public  static  void inc(){
        synchronized (SynchronizedDemo.class){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count++ ;
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            new Thread(()->SynchronizedDemo.inc()).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结果为："+count);
    }
}
