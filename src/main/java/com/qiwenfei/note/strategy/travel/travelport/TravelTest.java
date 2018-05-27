package com.qiwenfei.note.strategy.travel.travelport;

import com.qiwenfei.note.strategy.travel.Visitor;

/**
 * 2018-05-27
 * sunshine
 */
public class TravelTest {

    public static void main(String[] args) {
        Visitor visitor = new Visitor("西安","云南");

        AirPlantNew airPlantNew = new AirPlantNew() ;
        airPlantNew.doSelect(airPlantNew);
        visitor.doTravel(airPlantNew);
    }
}
