package com.qiwenfei.note.strategy.travel.travelport;

/**
 * 2018-05-27
 * sunshine
 */
public class Train implements Travel {

    @Override
    public void doTravel(String org, String dest) {
        System.out.println("坐火车从"+org+"到"+dest);
    }
}
