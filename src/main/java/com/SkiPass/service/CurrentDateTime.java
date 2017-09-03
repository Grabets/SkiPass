package com.SkiPass.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class CurrentDateTime {

    private static ZoneId zoneId = ZoneId.of("Europe/Kiev");
    private static LocalDateTime currentDateTime = LocalDateTime.now(zoneId);;

    public static LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

}
