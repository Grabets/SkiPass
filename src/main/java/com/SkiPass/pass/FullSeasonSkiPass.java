package com.SkiPass.pass;

import com.SkiPass.service.SeasonTime;
import com.SkiPass.service.SkiPassType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@ToString
public class FullSeasonSkiPass implements SkiPass, DateBasedSkiPass {
    private final String id;
    private final int year;
    private static int count;
    private boolean isBlocked;
    private final boolean isYear;

    private boolean isActive;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private FullSeasonSkiPass(Builder b) {
        this.id = b.id;
        this.year = b.year;
        this.isBlocked = b.isBlocked;
        this.isYear = true;
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
        return true;
    }

    private boolean setDateTimePeriod(LocalDateTime currentDateTime) {
        if (currentDateTime.getYear()==year) {
            startDateTime = SeasonTime.getStartSeason(year);
            endDateTime = SeasonTime.getEndSeason(year);
            if (startDateTime.isBefore(currentDateTime) & endDateTime.isAfter(currentDateTime))
                return true;
        }
        return false;
    }

    public static class Builder {
        private String id;
        private int year;
        private Boolean isBlocked;

        public Builder year(int year) {
            this.year = year;
            this.isBlocked = false;
            this.id = "FS_PASS"+Integer.toString(++count)+"y:"+year;
            return this;
        }

        public FullSeasonSkiPass build() {
            return new FullSeasonSkiPass(this);
        }
    }

}