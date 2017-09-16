package com.SkiPass.service;

import com.SkiPass.pass.QuantityBasedSkiPass;
import com.SkiPass.pass.WorkingDayQuantitySkiPass;

import java.time.LocalDateTime;

public class FixedNumberApplicationStrategy implements SkiPassApplicationStrategy {

    private QuantityBasedSkiPass quantityBasedSkiPass;

    public FixedNumberApplicationStrategy(QuantityBasedSkiPass skiPass) {
        this.quantityBasedSkiPass = skiPass;
    }

    public FixedNumberApplicationStrategy(WorkingDayQuantitySkiPass skiPass) {
        this.quantityBasedSkiPass = skiPass;
    }

    @Override
    public boolean isValid(LocalDateTime currentDateTime) {
        if (quantityBasedSkiPass.isWeekend() || SeasonTime.isWeekend(currentDateTime))
            return quantityBasedSkiPass.getUpsQuantity() > 0;
        else
            return false;
    }

    @Override
    public void scroll() {
        quantityBasedSkiPass.pullOfUpsQuantity();
    }
}
