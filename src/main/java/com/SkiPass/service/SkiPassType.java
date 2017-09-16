package com.SkiPass.service;

public enum SkiPassType {
    NUMBER_BASED(FixedNumberApplicationStrategy.class),
    TIME_BASED(TimeBasedApplicationStrategy.class);

    private Class applicationStrategy;

    public Class getApplicationStrategy() {
        return applicationStrategy;
    }

    SkiPassType(Class applicationStrategy) {
        this.applicationStrategy = applicationStrategy;
    }
}
