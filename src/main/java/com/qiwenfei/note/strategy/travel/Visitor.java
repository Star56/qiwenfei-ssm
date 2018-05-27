package com.qiwenfei.note.strategy.travel;

import com.qiwenfei.note.strategy.travel.travelport.TravelWay;
import com.qiwenfei.note.strategy.travel.travelport.TravelWayNew;

/**
 * 2018-05-27
 * sunshine
 */
public class Visitor {

    private  String org ;

    private  String dest ;

    public Visitor(String org, String dest) {
        this.org = org;
        this.dest = dest;
    }

    public void doTravel(TravelWayNew travelWay){
        travelWay.newInstanceTravel().doTravel(org,dest);
    }
}
