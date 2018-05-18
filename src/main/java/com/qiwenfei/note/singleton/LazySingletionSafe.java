package com.qiwenfei.note.singleton;

import java.io.Serializable;

/**
 * 2018-05-17
 *懒汉式：静态内部类实现：线程安全
 * sunshine
 */
public class LazySingletionSafe implements Serializable {

     private  LazySingletionSafe(){

     }

     public LazySingletionSafe getInstance(){
        return Lasyholder.lazySingletionSafe ;
     }

     private static  class  Lasyholder{
         private static final LazySingletionSafe  lazySingletionSafe= new LazySingletionSafe();
     }

}
