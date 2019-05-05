package com.qiwenfei.note.strategy.springstrategy;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2019/2/24
 * sunshine
 *
 * 利用spring 中bean 加载实例化实现符合开闭原则的策略模式
 *
 */
public abstract class Card implements PaymentMethod{

    static Map<String,PaymentMethod> paymentMethodMap = new ConcurrentHashMap<>();

    /**
     * @PostConstruct 调用构造器后执行
     * 子类实例化时先调用父类构造器
     * 每个子类bean实例化后就会将对象加载Map
     */
    @PostConstruct
    public void init(){
        paymentMethodMap.put(getType(),this);
    }

    protected abstract String getType() ;

    @Override
    public void pay(int cents){
        System.out.println("use："+getType()+"->payed "+cents +"cents");
        executeTx(cents);
    }
    public abstract void executeTx(int cents);

}
