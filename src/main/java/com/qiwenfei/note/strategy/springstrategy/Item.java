package com.qiwenfei.note.strategy.springstrategy;

/**
 * 2019/2/24
 * sunshine
 */
public class Item {
    private  String name  ;

    private int cents ;

    public Item(String name, int cents) {
        this.name = name;
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }
}
