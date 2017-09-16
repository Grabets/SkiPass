package com.SkiPass.turnstile;

import com.SkiPass.pass.FullSeasonSkiPass;
import com.SkiPass.pass.SkiPass;
import com.SkiPass.pass.WorkingDayQuantitySkiPass;
import com.SkiPass.service.ApplicationStrategyFactory;
import com.SkiPass.service.SkiPassApplicationStrategy;
import com.SkiPass.service.UpsQuantity;
import com.SkiPass.system.SkiPassCardBuilder;

import java.time.LocalDateTime;

public class Turnstyle {
    private LocalDateTime currentDateTime;

    public Turnstyle(LocalDateTime currentDateTime) {
        setCurrentDateTime(currentDateTime);
    }

    //TODO:incorrect with reading, because its not only reading, change this method
    public boolean readCard(SkiPass skiPass){
        try {
            SkiPassApplicationStrategy appStrategy = ApplicationStrategyFactory.createStrategy(skiPass);
            if (appStrategy.isValid(currentDateTime)){
                open(appStrategy);
                return true;
            }
        }
        catch (Exception e){
            //TODO: do it with log4j
            e.printStackTrace();
            System.out.println("Exception handled");
        }
        return false;
    }

    public void open(SkiPassApplicationStrategy applicationStrategy){
        //here some real action which open turnstyle
        applicationStrategy.scroll();
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

}
