package com.SkiPass;


import com.SkiPass.pass.SkiPassCardBuilder;
import com.SkiPass.service.UpsQuantity;

public class Main {
    public static void main(String[] args) {
        SkiPassCardBuilder cardBuilder = new SkiPassCardBuilder();
        cardBuilder.createFullSeasonSkiPass(2018);
        System.out.println(cardBuilder.createWorkingDayQuantityPass(UpsQuantity.TWENTY) );


    }
}
