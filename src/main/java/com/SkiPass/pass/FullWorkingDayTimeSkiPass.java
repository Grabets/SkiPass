package com.SkiPass.pass;

import com.SkiPass.service.FullDayTimeQuantity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FullWorkingDayTimeSkiPass implements SkiPass {
    private final String id;
    private static int count;
    private boolean isBlocked;
    private final boolean isWeekend;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private final int daysQuantity;

    private FullWorkingDayTimeSkiPass(Builder b) {
        this.id = b.id;
        this.isBlocked = false;
        this.isWeekend = false;
        this.daysQuantity = b.daysQuantity;
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

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
        endDateTime = startDateTime;
        endDateTime.plusDays(daysQuantity);
    }
}
