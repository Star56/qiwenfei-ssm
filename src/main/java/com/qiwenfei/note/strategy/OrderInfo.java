package com.qiwenfei.note.strategy;

import com.qiwenfei.note.strategy.payport.PayType;

/**
 * 2018-05-24
 * sunshine
 *
 * 订单信息
 *
 * 策略模式：对方法，算法，实现方式的一种封装，只关心最后的结果
 *
 */
public class OrderInfo {

    private String uid ;
    private double fees ;
    private String orderid ;

    public OrderInfo(String uid, double fees, String orderid) {
        this.uid = uid;
        this.fees = fees;
        this.orderid = orderid;
    }

    public  PayState doPay(PayType payType){
         return  payType.doGetPayment().pay(this.uid,this.fees);
    }
}
