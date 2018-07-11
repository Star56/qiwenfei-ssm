package com.qiwenfei.note.decorator.extend;

/**
 * 2018/7/10
 * sunshine
 */
public class SwimCar extends SuperCar {

    private SuperCar  car ;

    public SwimCar(SuperCar car) {
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("水里游");
        car.move();
    }
}
