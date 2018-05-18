package com.qiwenfei.note.singleton;

import java.io.Serializable;

/**
 * 2018-05-17
 * 懒汉式：当首次使用的时候产生对象
 * 这个简单的懒汉式，线程不安全：因为会通过new产生对象，
 * 高并发时会产生不一样的对象
 * sunshine
 */
public class LazySingletonSimple implements Serializable {

    private  static LazySingletonSimple lazySingletonSimple;
    private LazySingletonSimple(){

    }

    public static LazySingletonSimple getInstance(){
        if (lazySingletonSimple ==null){
            lazySingletonSimple = new LazySingletonSimple();
        }
        return lazySingletonSimple;
    }


}
