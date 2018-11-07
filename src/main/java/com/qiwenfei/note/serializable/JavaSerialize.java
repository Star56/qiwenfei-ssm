package com.qiwenfei.note.serializable;

import java.io.*;

/**
 * 2018/6/5
 * sunshine
 */
public class JavaSerialize implements ISerializable{
    @Override
    public <T> byte[] doserialize(T obj) throws Exception {

        ByteArrayOutputStream byteArrayInputStream = null;
        ObjectOutputStream  outputStream = null ;
        try {
             byteArrayInputStream = new ByteArrayOutputStream();
              outputStream = new ObjectOutputStream(byteArrayInputStream);

            outputStream.writeObject(obj);
            return byteArrayInputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null !=byteArrayInputStream){
                byteArrayInputStream.close();
            }
            if(null !=outputStream){
                outputStream.close();
            }

        }
        return  null;
    }

    @Override
    public <T> T deserialize(byte[] datas, Class<T> clazz) throws Exception {

        ByteArrayInputStream byteArrayInputStream = null ;
        ObjectInputStream  objectInputStream = null ;
        try {
             byteArrayInputStream = new ByteArrayInputStream(datas);
             objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return (T)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null !=byteArrayInputStream){
                byteArrayInputStream.close();
            }
            if(null!=objectInputStream){

                objectInputStream.close();
            }

        }

        return null;
    }
}
