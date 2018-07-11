package com.qiwenfei.note.decorator.wraper;

import com.qiwenfei.note.decorator.ICar;

/**
 * 2018/7/10
 * sunshine
 */
public class FlyCar extends SuperCar {
    public FlyCar(ICar iCar) {
        super(iCar);
    }

    public void fly(){
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        this.fly();
        super.move();
    }
}
