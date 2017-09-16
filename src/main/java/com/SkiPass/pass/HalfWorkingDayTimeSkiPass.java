package com.SkiPass.pass;

import com.SkiPass.service.HalfDayTimeQuantity;
import com.SkiPass.service.SkiPassType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;


public class HalfWorkingDayTimeSkiPass implements SkiPass, DateBasedSkiPass {
    private final String id;
    private static int count;
    private boolean isBlocked;
    private boolean isActive;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private final int hoursQuantity;
    private final boolean isMorning;

    private HalfWorkingDayTimeSkiPass(Builder b) {
        this.id = b.id;
        this.isBlocked = false;
        this.hoursQuantity = b.hoursQuantity;
        this.isMorning = b.isMorning;
        isActive = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isBlocked() {
        return isBlocked;
    }

    @Override
    public boolean activate(LocalDateTime current) {
        if (setDateTimePeriod(current)){
            isActive = true;
            return true;
        }
        return false;
    }

    @Override
    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
        isActive = false;
    }

    @Override
    public SkiPassType getType() {
        return SkiPassType.TIME_BASED;
    }

    @Override
    public boolean isWeekend() {
        return false;
    }

    //TODO: when this card firstly activate startDateTime need to be init
    public static class Builder {
        private String id;
        private int hoursQuantity;
        private boolean isMorning;


        public Builder HoursQuantityAndPartOfDay(HalfDayTimeQuantity timeQuantity) {
            this.hoursQuantity = timeQuantity.getQuantityOfHours();
            this.isMorning = timeQuantity.isMorning();
            this.id = "HWDT_PASS"+Integer.toString(++count)+"daysQuantity:"+timeQuantity.getQuantityOfHours()+"isMorning"+timeQuantity.isMorning();
            return this;
        }

        public HalfWorkingDayTimeSkiPass build() {
            return new HalfWorkingDayTimeSkiPass(this);
        }
    }

    public boolean setDateTimePeriod(LocalDateTime currentDateTime) {
        startDateTime = currentDateTime;

        if (startDateTime.getDayOfWeek().name().equals(DayOfWeek.SATURDAY.name())
                || startDateTime.getDayOfWeek().name().equals(DayOfWeek.SUNDAY.name()))
            return false;
        else {
            if (isMorning & startDateTime.getHour()<13 & startDateTime.getHour()>=9){
                endDateTime = startDateTime;
                endDateTime.withHour(13);
                return true;
            }
            if (!isMorning & startDateTime.getHour()>=13 & startDateTime.getHour()<17 ){
                endDateTime = startDateTime;
                endDateTime.withHour(17);
                return true;
            }
            return false;
        }
    }
}
