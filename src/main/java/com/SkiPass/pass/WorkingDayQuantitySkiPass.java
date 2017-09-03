package com.SkiPass.pass;

import com.SkiPass.service.UpsQuantity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WorkingDayQuantitySkiPass implements SkiPass {
    private final String id;
    private static int count;
    private boolean isBlocked;
    private final int upsQuantity;
    private final boolean isWeekend;

    private WorkingDayQuantitySkiPass(Builder b) {
        this.id = b.id;
        this.isBlocked = false;
        this.isWeekend = false;
        this.upsQuantity = b.upsQuantity;
    }

    public static class Builder {
        private String id;
        private int upsQuantity;

        public Builder countOfUps(UpsQuantity quantity) {
            this.upsQuantity = quantity.getQuantity();
            this.id = "WDQ_PASS"+Integer.toString(++count)+"quantity:"+upsQuantity;
            return this;
        }

        public WorkingDayQuantitySkiPass build() {
            return new WorkingDayQuantitySkiPass(this);
        }
    }

}