package com.qiwenfei.note.proxy.dynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 2019/7/1
 * sunshine
 */
public class CglibProxy implements MethodInterceptor {

    private  Object object ;

    public Object getInstance(Object obj)throws Exception{
        object = obj ;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.object.getClass());
        enhancer.setCallback(this);
        enhancer.setClassLoader(this.object.getClass().getClassLoader());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        return methodProxy.invokeSuper(o,objects);
    }


}
