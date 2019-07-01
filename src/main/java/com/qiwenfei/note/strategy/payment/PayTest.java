package com.qiwenfei.note.strategy.payment;

import com.qiwenfei.note.strategy.springstrategy.Card;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2019/7/1
 * sunshine
 */
public class PayTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application-common.xml");
        context.start();
        ThridPay  thridPay = new Alipay();
        thridPay.pay(10);
    }
}
