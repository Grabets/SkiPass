package com.SkiPass.pass;

import com.SkiPass.service.SkiPassType;
import com.SkiPass.service.UpsQuantity;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class WorkingDayQuantitySkiPass implements SkiPass, QuantityBasedSkiPass {
    private final String id;
    private static int count;
    private boolean isBlocked;
    private int upsQuantity;
    private final boolean isWeekend;

    private boolean isActive;

    private WorkingDayQuantitySkiPass(Builder b) {
        this.id = b.id;
        this.isBlocked = false;
        this.isWeekend = false;
        this.upsQuantity = b.upsQuantity;
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
        return SkiPassType.NUMBER_BASED;
    }
    @Override
    public int getUpsQuantity() {
        return upsQuantity;
    }

    @Override
    public int pullOfUpsQuantity() {
        return --upsQuantity;
    }

    @Override
    public boolean isWeekend() {
        return isWeekend;
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