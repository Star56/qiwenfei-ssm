package com.qiwenfei.note.strategy.springstrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/2/24
 * sunshine
 */
public class ShopCar {

    List<Item> items = new ArrayList<>();

    protected  void addItem(Item item){
        items.add(item);
    }
    protected void removeItem(Item item){
        items.remove(item);
    }

    protected int getSumCents(){
       return  items.stream().mapToInt(item->item.getCents()).sum();
    }

    public void pay(PaymentMethod method){
        method.pay(getSumCents());
    }
}
