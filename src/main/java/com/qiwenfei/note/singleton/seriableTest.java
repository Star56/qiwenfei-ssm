package com.qiwenfei.note.singleton;

import java.io.*;

/**
 * 2018-05-20
 * sunshine
 */
public class seriableTest {

    public static void main(String[] args) {
        Seriable s1 = Seriable.getInstance();
        Seriable s2 = null ;
        FileOutputStream outputStream = null ;
        FileInputStream fis = null ;
        try {
            outputStream = new FileOutputStream("seriable.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(s1);
            objectOutputStream.close();

             fis = new FileInputStream("seriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);

            s2 = (Seriable) ois.readObject();
            ois.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1==s2);


        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e2){
            e2.printStackTrace();
        }



    }
}
