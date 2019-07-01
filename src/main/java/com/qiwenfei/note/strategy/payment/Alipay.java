package com.qiwenfei.note.strategy.payment;

/**
 * 2019/7/1
 * sunshine
 */
public class Alipay extends ThridPay{
    @Override
    public String getType() {
        return "alipay";
    }

    @Override
    public void exectx(double cents) {
        System.out.println("支付事务");
    }
}
