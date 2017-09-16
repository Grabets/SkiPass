package com.SkiPass.pass;

import com.SkiPass.service.FullDayTimeQuantity;
import com.SkiPass.service.SkiPassType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class FullWorkingDayTimeSkiPass implements SkiPass, DateBasedSkiPass {
    private final String id;
    private static int count;
    private boolean isBlocked;

    private boolean isActive;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private final int daysQuantity;

    private FullWorkingDayTimeSkiPass(Builder b) {
        this.id = b.id;
        isActive = false;
        this.isBlocked = false;
        this.daysQuantity = b.daysQuantity;
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
        setDateTimePeriod(current);
        isActive = true;
        return true;
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

    public boolean isWeekend() {
        return false;
    }

    private boolean setDateTimePeriod(LocalDateTime currentDateTime) {
        this.startDateTime = currentDateTime;
        endDateTime = startDateTime.plusDays(daysQuantity);
        return true;
    }

    //TODO: when this card firstly activate startDateTime need to be init
    public static class Builder {
        private String id;
        private int daysQuantity;

        public Builder daysQuantity(FullDayTimeQuantity timeQuantity) {
            this.daysQuantity = timeQuantity.getQuantityOfDays();
            this.id = "WDT_PASS"+Integer.toString(++count)+"daysQuantity:"+timeQuantity.getQuantityOfDays();
            return this;
        }

        public FullWorkingDayTimeSkiPass build() {
            return new FullWorkingDayTimeSkiPass(this);
        }
    }

}
