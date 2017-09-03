package com.SkiPass.pass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FullSeasonSkiPass implements SkiPass {
    private final String id;
    private final int year;
    private static int count;
    private boolean isBlocked;
    private final boolean isYear;

    private FullSeasonSkiPass(Builder b) {
        this.id = b.id;
        this.year = b.year;
        this.isBlocked = b.isBlocked;
        this.isYear = true;
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