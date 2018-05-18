package com.qiwenfei.note.singleton;

import com.sun.deploy.util.StringUtils;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2018-05-18
 * 注册登记式
 * sunshine
 */
public class RegisterSingleton implements Serializable {

    private static Map<String,Object> regMap = new ConcurrentHashMap<String,Object>();

    public  RegisterSingleton getInstance(String name){
            if("".equals(name)||null == name){
                   name = RegisterSingleton.class.getName();
            }
            if(null ==regMap.get(name)){
                try {
                    regMap.put(name,Class.forName(name).newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return  (RegisterSingleton) regMap.get(name);
    }
}
