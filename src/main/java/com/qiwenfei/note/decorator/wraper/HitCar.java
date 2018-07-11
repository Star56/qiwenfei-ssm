package com.qiwenfei.note.decorator.wraper;

import com.qiwenfei.note.decorator.ICar;

/**
 * 2018/7/10
 * sunshine
 */
public class HitCar extends SuperCar {
    public HitCar(ICar iCar) {
        super(iCar);
    }

    @Override
    public void move() {
        System.out.println("可以攻击敌人");
        super.move();
    }
}
