package com.SkiPass.pass;

import com.SkiPass.service.SkiPassType;

import java.time.LocalDateTime;

public interface SkiPass {

    String getId();
    boolean isBlocked();
    class Builder {}
    boolean activate(LocalDateTime current);
    void setBlocked(boolean blocked);
    SkiPassType getType();
}
