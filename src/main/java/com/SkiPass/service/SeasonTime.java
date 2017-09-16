package com.SkiPass.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Created by bogdan on 10/8/2016.
 */
public class SeasonTime {

    public static LocalDateTime getStartSeason(int year) {
        if (year>2016 & year<2030)
            return LocalDateTime.of(year-1,12,1,00,00,00);
        return LocalDateTime.of(2016,12,1,00,00,00);
    }

    public static LocalDateTime getEndSeason(int year) {
        if (year>2016 & year<2030)
            return LocalDateTime.of(year,4,1,00,00,00);
        return LocalDateTime.of(2017,04,01,00,00,00);
    }

    public static boolean isWeekend(LocalDateTime current){
        if (current.getDayOfWeek().name().equals(DayOfWeek.SATURDAY.name())
                || current.getDayOfWeek().name().equals(DayOfWeek.SUNDAY.name()))
            return true;
        else
            return false;
    }


}
