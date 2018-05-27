package com.qiwenfei.note.strategy.travel.travelport;

/**
 * 2018-05-27
 * sunshine
 * 使用抽象类，满足开闭原则；此处代码存在优化空间
 */
public abstract class TravelWayNew {

    public Travel travel ;

    public abstract void doSelect(Travel travel);

    public Travel newInstanceTravel(){
        return travel ;
    }
}
