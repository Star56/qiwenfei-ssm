package com.qiwenfei.note.decorator;

import com.qiwenfei.note.decorator.old.Car;
import com.qiwenfei.note.decorator.wraper.FlyCar;
import com.qiwenfei.note.decorator.wraper.HitCar;
import com.qiwenfei.note.decorator.wraper.SuperCar;

/**
 * 2018/7/10
 * sunshine
 *
 * 装饰类：SuperCar子类、被装饰类Car
 *
 * 装饰类：降低系统耦合度；主要用于功能增强，体现在方法的扩展与覆盖
 * 装饰器与被装饰器都实现同一接口：满足同源同宗
 * 是is-a的关系
 *
 */
public class CarTest {

    public static void main(String[] args) {
        ICar flyCar = new HitCar(new FlyCar(new Car()));

        flyCar.move();

    }
}
