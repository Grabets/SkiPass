package com.SkiPass.system;

import com.SkiPass.pass.FullSeasonSkiPass;
import com.SkiPass.pass.FullWorkingDayTimeSkiPass;
import com.SkiPass.pass.HalfWorkingDayTimeSkiPass;
import com.SkiPass.pass.WorkingDayQuantitySkiPass;
import com.SkiPass.service.FullDayTimeQuantity;
import com.SkiPass.service.HalfDayTimeQuantity;
import com.SkiPass.service.UpsQuantity;

public class SkiPassCardBuilder {

    public static FullSeasonSkiPass createFullSeasonSkiPass (int year){
        if (year >2017 && year < 2030)
        return new FullSeasonSkiPass.Builder().year(year).build();
        else {
            //TODO : use in this case Logger
            System.out.println("You try to build FullSeasonSkiPass with incorrect year");
            return null;
        }
    }

    public static WorkingDayQuantitySkiPass createWorkingDayQuantityPass (UpsQuantity quantity){
        return new WorkingDayQuantitySkiPass.Builder().countOfUps(quantity).build();
    }

    public static FullWorkingDayTimeSkiPass createFullWorkingDayTimePass (FullDayTimeQuantity quantity){
        return new FullWorkingDayTimeSkiPass.Builder().daysQuantity(quantity).build();
    }

    public static HalfWorkingDayTimeSkiPass createHalfWorkingDayTimePass (HalfDayTimeQuantity quantity){
        return new HalfWorkingDayTimeSkiPass.Builder().HoursQuantityAndPartOfDay(quantity).build();
    }
}
