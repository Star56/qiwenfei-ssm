package com.qiwenfei.note.singleton;

import java.io.Serializable;

/**
 * 2018-05-17
 * 饿汉式单例模式:
 *   不管是否使用，先产生一个对象
 * sunshine
 */
public class HungrySingleton implements Serializable {
    private static final  HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON ;
    }



}
