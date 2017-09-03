package com.SkiPass.pass;

import com.SkiPass.service.FullDayTimeQuantity;
import com.SkiPass.service.HalfDayTimeQuantity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HalfWorkingDayTimeSkiPass implements SkiPass {
    private final String id;
    private static int count;
    private boolean isBlocked;
    private final boolean isWeekend;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private final int hoursQuantity;
    private final boolean isMorning;

    private HalfWorkingDayTimeSkiPass(Builder b) {
        this.id = b.id;
        this.isBlocked = false;
        this.isWeekend = false;
        this.hoursQuantity = b.hoursQuantity;
        this.isMorning = b.isMorning;
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
    //TODO: update to correct logics with hours and part of day variables
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
        endDateTime = startDateTime;


    }
}
