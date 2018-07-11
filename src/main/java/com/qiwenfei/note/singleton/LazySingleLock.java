package com.qiwenfei.note.singleton;

/**
 * 2018/6/15
 * sunshine
 */
public class LazySingleLock {

    private  static LazySingleLock instance ;

    private LazySingleLock(){

    }

    public  LazySingleLock  getLazySingleInstance(){

         if(null==instance){
             synchronized (LazySingleLock.class){
                 instance = new LazySingleLock();
             }
         }
        return instance ;
    }
}
