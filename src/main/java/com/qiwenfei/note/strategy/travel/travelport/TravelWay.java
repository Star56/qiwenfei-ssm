package com.qiwenfei.note.strategy.travel.travelport;

/**
 * 2018-05-27
 * sunshine
 */
public enum TravelWay  {

    CARTRAVEL_WAY(new Car()),TRAINTRAVEL_WAY(new Train()),AIRPLANTRAVEL_WAY(new AirPlanet()) ;

    private  Travel travel;

    TravelWay(Travel travel) {

        this.travel = travel;
    }

    public Travel  getTravelWay(){
        return this.travel ;
    }
}
