package com.SkiPass.service;

import java.time.LocalDateTime;

/**
 * Created by bogdan on 10/8/2016.
 */
public class SeasonTime {

    public static LocalDateTime getStartSeason(String year) {
        if (Integer.parseInt(year)>2016 && Integer.parseInt(year)<2030)
            return LocalDateTime.of(Integer.parseInt(year)-1,12,1,00,00,00);
        return LocalDateTime.of(2016,12,1,00,00,00);
    }

    public static LocalDateTime getEndSeason(String year) {
        if (Integer.parseInt(year)>2016 && Integer.parseInt(year)<2030)
            return LocalDateTime.of(Integer.parseInt(year),4,1,00,00,00);
        return LocalDateTime.of(2017,04,01,00,00,00);
    }
}
