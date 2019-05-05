package com.qiwenfei.note.strategy.springstrategy;

import org.springframework.stereotype.Service;

/**
 * 2019/2/24
 * sunshine
 */
@Service
public class DebitCard extends Card {
    @Override
    protected String getType() {
        return "debit";
    }

    @Override
    public void executeTx(int cents) {
        System.out.println("debitCard payed:"+cents +" cents");
    }
}
