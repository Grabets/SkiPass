package com.SkiPass.service;

import java.time.LocalDateTime;

public interface SkiPassApplicationStrategy {
    boolean isValid(LocalDateTime currentDateTime);
    void scroll();

}
