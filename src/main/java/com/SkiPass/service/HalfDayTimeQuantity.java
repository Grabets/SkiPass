package com.SkiPass.service;

import lombok.Getter;

@Getter
public enum HalfDayTimeQuantity {
    MORNING_THREE_HOURS_PER_DAY(true,3),
    EVENING_THREE_HOURS_PER_DAY(false,3);

    private boolean isMorning;
    private int quantityOfHours;

    HalfDayTimeQuantity(boolean partOfDay, int quantityOfHours){
        this.isMorning = partOfDay;
        this.quantityOfHours = quantityOfHours;
    }
}
