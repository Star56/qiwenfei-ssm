package com.qiwenfei.note.strategy.springstrategy;

/**
 * 2019/2/24
 * sunshine
 * 将支付方式抽象出来，可能有多种支付方式：
 * 使用卡（卡分为：信用卡、储蓄卡），支付宝的，微信的
 */
public interface PaymentMethod {

   void pay(int cents);
}
