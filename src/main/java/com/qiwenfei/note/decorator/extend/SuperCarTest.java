package com.qiwenfei.note.decorator.extend;

/**
 * 2018/7/10
 * sunshine
 */
public class SuperCarTest {

    public static void main(String[] args) {
        SuperCar car = new FlyCar(new SwimCar(new SuperCar() {
            @Override
            public void move() {
                System.out.println("超级汽车");
            }
        }));
        car.move();
    }
}
