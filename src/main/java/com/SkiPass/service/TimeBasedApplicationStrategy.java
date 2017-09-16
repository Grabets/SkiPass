package com.SkiPass.service;

import com.SkiPass.pass.DateBasedSkiPass;
import com.SkiPass.pass.FullWorkingDayTimeSkiPass;

import java.time.LocalDateTime;

public class TimeBasedApplicationStrategy implements SkiPassApplicationStrategy {
    DateBasedSkiPass dateBasedSkiPass;

    public TimeBasedApplicationStrategy(DateBasedSkiPass dateBasedSkiPass) {
        this.dateBasedSkiPass = dateBasedSkiPass;
    }

    public TimeBasedApplicationStrategy(FullWorkingDayTimeSkiPass dateBasedSkiPass) {
        this.dateBasedSkiPass = dateBasedSkiPass;
    }

    @Override
    public boolean isValid(LocalDateTime currentDateTime) {
        return false;
    }

    @Override
    public void scroll() {

    }
}
