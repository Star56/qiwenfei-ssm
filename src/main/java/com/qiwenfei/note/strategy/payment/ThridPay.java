package com.qiwenfei.note.strategy.payment;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2019/7/1
 * sunshine
 */
public abstract class ThridPay implements Payment {
    //构建一个Map将实例化的支付方式缓存起来
    static Map<String,Payment> paymentMap = new ConcurrentHashMap<String, Payment>();
    //使用Spring 属性
    //当子类初始化时会调用父类的构造器，调用构造器后调用被PostConstruct注解的方法
    @PostConstruct
    private void init(){
        paymentMap.put(getType(),this);
    }
    @Override
    public void pay(double cents) {
        System.out.println("使用："+getType()+"支付" +cents+"元");
        //不同的支付商支付事务逻辑不同
        exectx(cents);
    }
    public abstract String  getType() ;

    public abstract  void exectx(double cents);
}
