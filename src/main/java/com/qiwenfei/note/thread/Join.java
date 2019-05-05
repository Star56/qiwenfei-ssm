package com.qiwenfei.note.thread;

import java.util.concurrent.TimeUnit;

/**
 * 2019/3/25
 * sunshine
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread pre = Thread.currentThread() ;
        for (int i = 0; i < 10; i++) {
             Thread thread = new Thread(new Domino(pre),String.valueOf(i));
            thread.start();
            pre = thread ;
        }
        TimeUnit.SECONDS.sleep(5);

    }

    static public class Domino implements Runnable{

        private Thread thread ;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminate");
        }
    }
}
