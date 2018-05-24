package com.qiwenfei.note.strategy.payport;

import com.qiwenfei.note.strategy.PayState;

/**
 * 2018-05-24
 * sunshine
 */
public class Alipay implements Payment{

    @Override
    public PayState pay(String uid, double fees) {

        System.out.println("支付宝支付");

        return null;
    }
}
