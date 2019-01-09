package com.qiwenfei.note.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2018/12/26
 * sunshine
 */
public class LockDemo {
    static Map<String,Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock  rwl  = new ReentrantReadWriteLock();
    static Lock  readLock  = rwl.readLock();
    static Lock  writeLock = rwl.writeLock();

    public static final Object get(String key){
        System.out.println("开始读取数据");
        readLock.lock();
        try {
            return  cacheMap.get(key);
        } finally {
            readLock.unlock();
        }
    }
    public static final Object put(String key,String value){
        writeLock.lock();
        System.out.println("开始写数据");
        try {
            return cacheMap.put(key,value);
        } finally {
            writeLock.unlock();
        }
    }


}
