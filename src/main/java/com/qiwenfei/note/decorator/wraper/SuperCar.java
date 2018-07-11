package com.qiwenfei.note.decorator.wraper;

import com.qiwenfei.note.decorator.ICar;

/**
 * 2018/7/10
 * sunshine
 */
public class SuperCar implements ICar {

    private ICar icar ;

    public  SuperCar(ICar iCar) {

        this.icar = iCar ;
    }

    @Override
    public void move() {
        icar.move();
    }
}
