package com.qiwenfei.note.strategy;

import com.qiwenfei.note.strategy.payport.PayType;

/**
 * 2018-05-24
 * sunshine
 */
public class PayStrategyTest {

    public static void main(String[] args) {
         OrderInfo orderInfo = new OrderInfo("2988899988",23.3d,"y888822");

        orderInfo.doPay(PayType.ALI_PAY);
    }
}
