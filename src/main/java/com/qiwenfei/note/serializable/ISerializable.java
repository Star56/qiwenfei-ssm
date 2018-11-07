package com.qiwenfei.note.serializable;

/**
 * 2018/6/5
 * sunshine
 *
 * 父类不实现序列化会导致从父类继承属性不会序列化
 *
 */
public interface ISerializable {

     <T> byte[] doserialize(T obj)throws Exception;

     <T> T deserialize(byte [] datas ,Class<T> clazz)throws Exception ;
}
