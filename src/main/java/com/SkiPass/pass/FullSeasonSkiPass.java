package com.SkiPass.pass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FullSeasonSkiPass {
    private final String id;
    private final int year;
    private static int count;
    private Boolean isBlocked;

    public static class Builder {
        private String id;
        private int year;
        private Boolean isBlocked;

        public Builder year(int year) {
            this.year = year;
            this.isBlocked = new Boolean(false);
            this.id = "FS_PASS"+Integer.toString(++count)+"y:"+year;
            return this;
        }

        public FullSeasonSkiPass build() {
            return new FullSeasonSkiPass(this);
        }
    }

    private FullSeasonSkiPass(Builder b) {
        this.id = b.id;
        this.year = b.year;
        this.isBlocked = b.isBlocked;
    }

    public static void main(String[] args) {
        FullSeasonSkiPass n = new FullSeasonSkiPass.Builder().year(5).build();
        FullSeasonSkiPass n1 = new FullSeasonSkiPass.Builder().year(52).build();
        FullSeasonSkiPass n2 = new FullSeasonSkiPass.Builder().year(533).build();
        FullSeasonSkiPass n3 = new FullSeasonSkiPass.Builder().year(544).build();
        System.out.println(n);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

    }
}