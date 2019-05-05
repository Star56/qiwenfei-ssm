package com.qiwenfei.note.strategy.springstrategy;

import org.springframework.stereotype.Service;

/**
 * 2019/2/24
 * sunshine
 */
@Service
public class CreditCard extends Card {
    @Override
    protected String getType() {
        return "credit";
    }

    @Override
    public void executeTx(int cents) {
        System.out.println("creditCard payed:"+cents +" cents");
    }
}
