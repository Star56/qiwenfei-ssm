package com.qiwenfei.note.concurrency;

/**
 * 2018/11/12
 * sunshine
 */
public class ThreadTest {
    static int a = 0 ;
    static int b = 0 ;
    static int x = 0 ;
    static int y = 0 ;


    public static void main(String[] args) throws InterruptedException {


       Thread t1 =  new Thread(()->{
            a = 1 ;
            x = b ;

        });

       Thread t2 =  new Thread(()->{
           b = 1 ;
           y = a ;
       });

       t1.start();
       t2.start();
/*       t1.join();
       t2.join();*/

       System.out.println("a:" +a);
       System.out.println("b:" +b);
       System.out.println("x:" +x);
       System.out.println("y:" +y);
    }



}
