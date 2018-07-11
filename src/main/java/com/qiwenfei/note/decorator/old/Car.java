package com.qiwenfei.note.decorator.old;

import com.qiwenfei.note.decorator.ICar;

/**
 * 2018/7/10
 * sunshine
 */
public class Car implements ICar {
    @Override
    public void move() {
        System.out.println("地上跑");
    }
}
