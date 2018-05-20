package com.qiwenfei.note.prototype;

import java.io.*;

/**
 * 2018-05-20
 * sunshine
 */
public class SheepA extends Sheep implements Serializable,Cloneable {

    public SheepA() {
        this.setHeight(1.5);
        this.setWeight(55.0);
        this.setSex(new Sex("公"));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深复制：引用对象复制的是对象属性，不是引用地址；
     * @return
     * @throws CloneNotSupportedException
     */
    protected  Object deepClone()throws CloneNotSupportedException{

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            Object object =    ois.readObject();
            ois.close();
            return  object ;

        }catch (Exception e){
            e.printStackTrace();
        }

         return null ;


    }
}
