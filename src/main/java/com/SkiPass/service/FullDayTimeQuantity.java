package com.SkiPass.service;

import lombok.Getter;

@Getter
public enum FullDayTimeQuantity {
    DAY(1),
    TWO_DAY(2),
    THREE_DAY(3),
    FIVE_DAY(5);

    private int quantityOfDays;

    FullDayTimeQuantity(int quantityOfDays){
        this.quantityOfDays = quantityOfDays;
    }
}
