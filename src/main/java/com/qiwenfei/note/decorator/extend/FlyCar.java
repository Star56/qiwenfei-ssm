package com.qiwenfei.note.decorator.extend;

/**
 * 2018/7/10
 * sunshine
 */
public class FlyCar extends SuperCar {

    private SuperCar car ;

    public FlyCar(SuperCar car) {
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("天空飞翔");
        car.move();
    }
}
