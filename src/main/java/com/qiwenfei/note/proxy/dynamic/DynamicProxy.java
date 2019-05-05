package com.qiwenfei.note.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 2018-05-21
 * sunshine
 *
 * 怎么对不同的调用方法做预处理：
 *  例如：订购机票之前预处理，文件封装前的预处理?
 */
public class DynamicProxy implements InvocationHandler {

    private  Object target ;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("机票订购/文件准备完成");


        return method.invoke(target,args);
    }

    public Object newInstanceProxy(Object object){
        this.target = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
