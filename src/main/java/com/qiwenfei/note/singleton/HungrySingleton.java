package com.qiwenfei.note.singleton;

import java.io.Serializable;

/**
 * 2018-05-17
 * sunshine
 * 饿汉式单例模式:
 *   不管是否使用，先产生一个对象；类加载时就立即初始化，创建对象；
 *   优点：执行效率高、用户体验好、线程安全
 *   缺点：对象不管是不使用都会创建，浪费资源
 */
public class HungrySingleton implements Serializable {
    private static final  HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON ;
    }



}
