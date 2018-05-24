package com.qiwenfei.note.strategy.payport;

/**
 * 2018-05-24
 * sunshine
 */
public enum PayType {
    ALI_PAY(new Alipay()),JD_PAY(new JDPay());

    private Payment payment ;

    PayType(Payment payment) {
        this.payment = payment ;
    }

    public Payment doGetPayment(){
        return payment;
    }
}
