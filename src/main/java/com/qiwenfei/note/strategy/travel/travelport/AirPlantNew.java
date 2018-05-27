package com.qiwenfei.note.strategy.travel.travelport;

/**
 * 2018-05-27
 * sunshine
 * 采用抽象类的方式：满足了开闭原则
 * 新装一种交通方式时，不需要修改原来的代码逻辑
 */
public class AirPlantNew extends TravelWayNew implements Travel {

    @Override
    public void doSelect(Travel travel) {
       this.travel = travel;
    }

    @Override
    public void doTravel(String org, String dest) {
        System.out.println("坐飞机从"+org+"到"+dest);
    }
}
