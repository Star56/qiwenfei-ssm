package com.qiwenfei.note.strategy.travel.travelport;

/**
 * 2018-05-27
 * sunshine
 */
public class Car implements Travel {

    @Override
    public void doTravel(String org, String dest) {
        System.out.println("坐汽车从"+org+"到"+dest);
    }
}
