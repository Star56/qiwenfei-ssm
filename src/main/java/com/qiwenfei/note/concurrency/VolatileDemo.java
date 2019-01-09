package com.qiwenfei.note.concurrency;

/**
 * 2018/12/25
 * sunshine
 */
public class VolatileDemo {

    volatile int i ;

    public void incr(){
        i++ ;
    }

    public static void main(String[] args) {
        new VolatileDemo().incr();
    }
}
