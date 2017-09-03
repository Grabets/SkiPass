package com.SkiPass.pass;

import com.SkiPass.service.UpsQuantity;

public class SkiPassCardBuilder {

    public FullSeasonSkiPass createFullSeasonSkiPass (int year){
        if (year >2017 && year < 2025)
        return new FullSeasonSkiPass.Builder().year(year).build();
        else {
            //TODO : use in this case Logger
            System.out.println("You try to build FullSeasonSkiPass with incorrect year");
            return null;
        }
    }

    public WorkingDayQuantitySkiPass createWorkingDayQuantityPass (UpsQuantity quantity){
        return new WorkingDayQuantitySkiPass.Builder().countOfUps(quantity).build();
    }


}
