package com.qiwenfei.note.strategy.payport;

import com.qiwenfei.note.strategy.PayState;

/**
 * 2018-05-24
 * sunshine
 */
public interface Payment {

    public PayState pay(String uid,double fees);

}
