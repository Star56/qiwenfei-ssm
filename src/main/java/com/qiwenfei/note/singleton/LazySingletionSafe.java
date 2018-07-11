package com.qiwenfei.note.singleton;

import java.io.Serializable;

/**
 * 2018-05-17
 *懒汉式：静态内部类实现：线程安全
 * 内部类：在第一次使用的时候加载与实例化
 * sunshine
 */
public class LazySingletionSafe implements Serializable {

    /**
     * 为了防止类被反射获取内部类，重新生成类对象
     */
    private static  boolean initialized = false ;

     private  LazySingletionSafe(){

          if(!initialized){
              initialized = !initialized ;
          }else{
              throw  new RuntimeException("单例被侵犯");
          }

     }

     public LazySingletionSafe getInstance(){
        return Lasyholder.lazySingletionSafe ;
     }

     private static  class  Lasyholder{
         private static final LazySingletionSafe  lazySingletionSafe= new LazySingletionSafe();
     }

}
