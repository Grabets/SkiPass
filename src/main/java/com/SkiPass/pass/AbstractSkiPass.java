package com.SkiPass.pass;

public abstract class AbstractSkiPass implements SkiPass {
    String id;
    boolean isBlocked;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Boolean isBlocked() {
        return isBlocked;
    }
}
