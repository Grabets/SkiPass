package com.SkiPass.service;

import lombok.Getter;

@Getter
public enum HalfDayTimeQuantity {
    MORNING_FOUR_HOURS_PER_DAY(true,4),
    EVENING_FOUR_HOURS_PER_DAY(false,4);

    private boolean isMorning;
    private int quantityOfHours;

    HalfDayTimeQuantity(boolean partOfDay, int quantityOfHours){
        this.isMorning = partOfDay;
        this.quantityOfHours = quantityOfHours;
    }
}
