package com.qiwenfei.note.singleton;

import java.io.Serializable;

/**
 * 2018-05-20
 * sunshine
 */
public class Seriable implements Serializable {

    private static final Seriable SERIABLE = new Seriable();

    private Seriable(){

    }
    public static Seriable getInstance(){
        return  SERIABLE;
    }

    /**
     * 该方法是为了防止通过序列化重新实例化对象
     * @return
     */
    private  Object readResolve(){
        return SERIABLE ;
    }
}
