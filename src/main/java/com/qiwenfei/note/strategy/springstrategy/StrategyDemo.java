package com.qiwenfei.note.strategy.springstrategy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2019/2/24
 * sunshine
 */
public class StrategyDemo {

    public static void main(String[] args) {
        ShopCar car = new ShopCar();
        car.addItem(new Item("数据",50000));
        car.addItem(new Item("食物",10000));

        ClassPathXmlApplicationContext  context =
                new ClassPathXmlApplicationContext("application-common.xml");
        context.start();
        car.pay(Card.paymentMethodMap.get("credit"));
    }
}
